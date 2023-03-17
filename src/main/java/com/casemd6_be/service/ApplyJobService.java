package com.casemd6_be.service;

import com.casemd6_be.model.ApplyJob;
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

    public Optional<ApplyJob> findOneApplyJobById(int id) {
        return iApplyJobRepo.findById(id);
    }

    public void save(ApplyJob applyJob) {
        iApplyJobRepo.save(applyJob);
    }

    public void delete(int id) {
        iApplyJobRepo.deleteById(id);
    }

    // tìm tất cả các job của 1 ng dùng đã apply
    public List<ApplyJob> findApplyJobByAccount(int id) {
        return iApplyJobRepo.findApplyJobByAccount_Id(id);
    }
}
