package com.casemd6_be.service;

import com.casemd6_be.model.Account;
import com.casemd6_be.model.Job;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    IJobRepo iJobRepo;

    public List<ListJobCompanyAccount> getAllJobByEmail(String email) {
        return iJobRepo.joinCompanyAndJobAndAccountByEmail(email);
    }

    public Job findJobById(int id) {
        return iJobRepo.findJobsById(id);
    }

    public void save(Job job) {
        iJobRepo.save(job);
    }
}
