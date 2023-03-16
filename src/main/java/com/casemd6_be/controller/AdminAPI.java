package com.casemd6_be.controller;

import com.casemd6_be.model.Account;
import com.casemd6_be.model.query.CompanyAndAccount;
import com.casemd6_be.service.AccountService;
import com.casemd6_be.service.CompanyService;
import com.casemd6_be.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminAPI {
    @Autowired
    CompanyService companyService;
    @Autowired
    AccountService accountService;
    @Autowired
    SendEmailService sendEmailService;

    @GetMapping("/ShowCompanyAdmin")
    public ResponseEntity<List<CompanyAndAccount>> getallCompanyNoEamil() {
        return new ResponseEntity<>(companyService.getallCompanyNoEamil(), HttpStatus.OK);
    }

    @GetMapping("blogComPany/{id}")
    public ResponseEntity<?> AdminBlockCompany(@PathVariable int id) {
        Account account = accountService.findbyid(id);
        boolean value = false;//Khoa
        boolean value2 = true;
        if (account.getStatus() == true) {
            account.setStatus(value);
            accountService.save(account);
            sendEmailService.sendMail(account.getEmail(), "Thông báo", "Tài khoản: " + account.getName() + " đã bị khóa bởi hệ thống vui lòng liên hệ tổng đài 19006868 để được hỗ trợ !");


            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            account.setStatus(value2);
            accountService.save(account);
            sendEmailService.sendMail(account.getEmail(), "Thông báo", "Tài khoản: " + account.getName() + " đã được mở khóa " +
                    "Tài khoản: " + account.getEmail() + ", Mật khẩu: " + account.getPassword() +
                    "Bạn ã có thể đăng nhập !. " +
                    "Chào mừng bạn trở lại ");
            return new ResponseEntity<>(HttpStatus.OK);

        }

    }


    @GetMapping("/showUserRole2")
    public ResponseEntity<List<Account>> getallAccountEqual2() {
        return new ResponseEntity<>(accountService.getallAccountEqual2(), HttpStatus.OK);
    }

    @GetMapping("BlogUser/{id}")
    public ResponseEntity<?> AdminBlockUser(@PathVariable int id) {
        Account account = accountService.findbyid(id);
        boolean value = false;//Khoa
        boolean value2 = true;
        if (account.getStatus() == true) {
            account.setStatus(value);
            accountService.save(account);
            sendEmailService.sendMail(account.getEmail(), "Thông báo", "Tài khoản: " + account.getName() + " đã bị khóa bởi hệ thống vui lòng liên hệ tổng đài 19006868 để được hỗ trợ !");


            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            account.setStatus(value2);
            accountService.save(account);
            sendEmailService.sendMail(account.getEmail(), "Thông báo", "Tài khoản: " + account.getName() + " đã được mở khóa " +
                    "Tài khoản: " + account.getEmail() + ", Mật khẩu: " + account.getPassword() +
                    "Bạn ã có thể đăng nhập !. " +
                    "Chào mừng bạn trở lại ");
            return new ResponseEntity<>(HttpStatus.OK);

        }

    }

    @GetMapping("/searchUser/{name}")
    public ResponseEntity<List<Account>> searchUserByName(@PathVariable String name) {
//        String value= '%'+name+'%';
        return new ResponseEntity<>(accountService.searchUserByName('%' + name + '%'), HttpStatus.OK);
    }

    @GetMapping("/searchCompany/{name}")
    public ResponseEntity<List<CompanyAndAccount>> searchCompanyByName(@PathVariable String name) {
        return new ResponseEntity<>(companyService.searchBynameCompany('%' + name + '%'), HttpStatus.OK);
    }


}
