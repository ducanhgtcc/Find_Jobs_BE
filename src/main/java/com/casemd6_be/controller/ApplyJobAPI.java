package com.casemd6_be.controller;

import com.casemd6_be.model.Account;
import com.casemd6_be.model.ApplyJob;
import com.casemd6_be.model.Job;
import com.casemd6_be.model.dto.UpImage;
import com.casemd6_be.model.query.ListApplyJob;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.service.AccountService;
import com.casemd6_be.service.ApplyJobService;
import com.casemd6_be.service.JobService;
import com.casemd6_be.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.Line;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/applyJob")
public class ApplyJobAPI {
    @Autowired
    ApplyJobService applyJobService;

    @Autowired
    AccountService accountService;

    @Autowired
    SendEmailService sendEmailService;

    @Autowired
    JobService jobService;

    @GetMapping("/{id}")
    public ResponseEntity<ApplyJob> findOneApplyJobById(@PathVariable int id) {
        return new ResponseEntity<>(applyJobService.findOneApplyJobById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ApplyJob>> findAllApplyJob() {
        return new ResponseEntity<>(applyJobService.findAllApplyJob(), HttpStatus.OK);
    }

    @GetMapping("/cv/{idApply}")
    public ResponseEntity<ListApplyJob> showApplyJobOfUserByCompanyCV(@PathVariable int idApply) {
        return new ResponseEntity<>(applyJobService.showApplyJobOfUserByCompanyCV(idApply), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApplyJob> applyJobUser(@RequestBody ApplyJob applyJob,@RequestParam(name = "email") String email,@RequestParam(name = "idJob") int idJob) {
        Account account = accountService.findAccountByUsername(email);
        account.setId(account.getId());
        applyJob.setAccount(account);

        Job job = new Job();
        job.setId(idJob);
        applyJob.setJob(job);
        applyJob.setCount(0);

        applyJob.setStatus(1);
        applyJob.setMessage("Đang chờ duyệt");

        applyJobService.save(applyJob);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/cancel")
    public ResponseEntity<ApplyJob> CancelApplyJobUser(@RequestBody ApplyJob applyJob) {
        ApplyJob applyJob1 = applyJobService.findOneApplyJobById(applyJob.getId());

        applyJob1.setStatus(0);
        applyJob1.setMessage("Đã hủy nộp Cv");
        applyJob1.setMessage("Đã hủy");
        applyJobService.save(applyJob1);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/cancelApplyJobOfCompany")
    public ResponseEntity<ApplyJob> cancelApplyJobOfCompany(@RequestBody ApplyJob applyJob) {
        ApplyJob applyJob1 = applyJobService.findOneApplyJobById(applyJob.getId());
        Account account = accountService.findbyid(applyJob1.getAccount().getId());
        ListJobCompanyAccount job = jobService.getOneJobbyID(applyJob1.getJob().getId());

        applyJob1.setStatus(3);
        applyJob1.setMessage("Yêu cầu ứng tuyển đã bị hủy");

        applyJobService.save(applyJob1);
        sendEmailService.sendMail(account.getEmail(), "Thông báo từ doanh nghiệp : " + job.getNameAcc(),
                "Xin chào : " +account.getName()+ "; " +
                        "Đơn xin việc của bạn vào mã công việc :" + job.getCodeJob() + " không được chấp nhận . Xin cảm ơn sự quan tâm của các bạn đến công ty chúng tôi.");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/confirmApplyJobOfCompany")
    public ResponseEntity<ApplyJob> confirmApplyJobOfCompany(@RequestBody ApplyJob applyJob) {
        ApplyJob applyJob1 = applyJobService.findOneApplyJobById(applyJob.getId());

        Account account = accountService.findbyid(applyJob1.getAccount().getId());
        ListJobCompanyAccount job = jobService.getOneJobbyID(applyJob1.getJob().getId());

        applyJob1.setStatus(2);
        applyJob1.setMessage("Yêu cầu ứng tuyển đã được xác nhận");

        applyJobService.save(applyJob1);
        sendEmailService.sendMail(account.getEmail(), "Thông báo từ doanh nghiệp : " + job.getNameAcc(),
                "Xin chào : " +account.getName()+ "; " +
                        "Đơn xin việc của bạn vào mã công việc :" + job.getCodeJob() + " đã được chấp nhận . Chúng tôi sẽ gửi lịch phỏng vấn tới bạn sau");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // xác nhận tuyển từ công ty
    @PostMapping("/confirmRecruitOfCompany")
    public ResponseEntity<ApplyJob> confirmRecruitOfCompany(@RequestBody ApplyJob applyJob) {
        ApplyJob applyJob1 = applyJobService.findOneApplyJobById(applyJob.getId());

        Account account = accountService.findbyid(applyJob1.getAccount().getId());
        ListJobCompanyAccount job = jobService.getOneJobbyID(applyJob1.getJob().getId());

        applyJob1.setCount(1);
        applyJob1.setMessage("Xin chúc mừng bạn đã được nhận");
        applyJobService.save(applyJob1);
        sendEmailService.sendMail(account.getEmail(), "Thông báo từ doanh nghiệp : " + job.getNameAcc(),
                "Xin chào : " +account.getName()+ "; " +
                        "Chúc mừng bạn đã trúng tuyển");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // xác nhận không tuyển từ công ty
    @PostMapping("/cancelRecruitOfCompany")
    public ResponseEntity<ApplyJob> cancelRecruitOfCompany(@RequestBody ApplyJob applyJob) {
        ApplyJob applyJob1 = applyJobService.findOneApplyJobById(applyJob.getId());

        Account account = accountService.findbyid(applyJob1.getAccount().getId());
        ListJobCompanyAccount job = jobService.getOneJobbyID(applyJob1.getJob().getId());

        applyJob1.setCount(2);
        applyJob1.setMessage("Xin thông báo bạn đã bị loại");
        applyJobService.save(applyJob1);
        sendEmailService.sendMail(account.getEmail(), "Thông báo từ doanh nghiệp : " + job.getNameAcc(),
                "Xin chào : " +account.getName()+ "; " +
                        "Bạn không đủ điều kiện trúng tuyển");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // quay lại trạng thái duyệt tuyển từ công ty
    @PostMapping("/backRecruitOfCompany")
    public ResponseEntity<ApplyJob> backRecruitOfCompany(@RequestBody ApplyJob applyJob) {
        ApplyJob applyJob1 = applyJobService.findOneApplyJobById(applyJob.getId());

        applyJob1.setCount(0);
        applyJob1.setMessage("Đang chờ duyệt...");
        applyJobService.save(applyJob1);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/upImg")
    public UpImage upImg(@RequestParam MultipartFile fileImg) {
        String nameImg = fileImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileImg.getBytes(), new File("C:\\Users\\hungchivang\\Desktop\\Module 6\\find_jobs_FE\\src\\assets\\img/" + nameImg));
            return new UpImage("assets/img/" + nameImg) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // tìm tất cả các job của 1 ng dùng đã apply
    @GetMapping("/account/{email}")
    public ResponseEntity<List<ListApplyJob>> showAllApplyJobByUser(@PathVariable String email) {
        return new ResponseEntity<>(applyJobService.showAllApplyJobByUser(email), HttpStatus.OK);
    }

    // tìm tất cả các job của công ty theo ứng viên
    @GetMapping("/company/{idCompany}")
    public ResponseEntity<List<ListApplyJob>> showAllApplyJobOfUserByCompany(@PathVariable int idCompany) {
        return new ResponseEntity<>(applyJobService.showAllApplyJobOfUserByCompany(idCompany), HttpStatus.OK);
    }

    // tìm kiếm các job theo tên ng dùng, tiêu đề, mã công việc
    @GetMapping("/company/search")
    public ResponseEntity<List<ListApplyJob>> searchApplyJobsWithUser(@RequestParam(name = "key") String key,@RequestParam(name = "idCompany")  int idCompany) {
        return new ResponseEntity<>(applyJobService.searchApplyJobsWithUser('%' + key + '%',idCompany), HttpStatus.OK);
    }
}
