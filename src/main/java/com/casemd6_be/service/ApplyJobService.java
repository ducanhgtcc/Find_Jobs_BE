package com.casemd6_be.service;

import com.casemd6_be.model.ApplyJob;
import com.casemd6_be.model.query.ListApplyJob;
import com.casemd6_be.repository.IApplyJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplyJobService {
    @Autowired
    IApplyJobRepo iApplyJobRepo;

    public List<ApplyJob> findAllApplyJob() {
        return (List<ApplyJob>) iApplyJobRepo.findAll();
    }

    public ApplyJob findOneApplyJobById(int idApply) {
        return iApplyJobRepo.findApplyJobsById(idApply);
    }

    public void save(ApplyJob applyJob) {
        iApplyJobRepo.save(applyJob);
    }


    // tìm tất cả các job của 1 ng dùng đã apply
    public List<ListApplyJob> showAllApplyJobByUser(String email) {
        return iApplyJobRepo.showAllApplyJobByUser(email);
    }

    // tìm tất cả các job của công ty theo ứng viên
    public List<ListApplyJob> showAllApplyJobOfUserByCompany(int idCompany) {
        return iApplyJobRepo.showAllApplyJobOfUserByCompany(idCompany);
    }

    public ListApplyJob showApplyJobOfUserByCompanyCV(int idApply) {
        return iApplyJobRepo.showApplyJobOfUserByCompanyCV(idApply);
    }

    // tìm kiếm các job theo tên ng dùng, tiêu đề, mã công việc
    public List<ListApplyJob> searchApplyJobsWithUser(String key,int idCompany) {
        return iApplyJobRepo.searchApplyJobsWithUser(key,idCompany);
    }
}
