package com.casemd6_be.service;

import com.casemd6_be.model.Job;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class JobService {
    @Autowired
    IJobRepo iJobRepo;

    public List<Job> getAllJob() {
        return (List<Job>) iJobRepo.findAll();
    }

    public List<ListJobCompanyAccount> getAllJob_Latest() {
        List<ListJobCompanyAccount> ListJob_Latest =  iJobRepo.joinCompanyAndJobAndAccount();
        Collections.reverse(ListJob_Latest);
        return ListJob_Latest;
    }
    public ListJobCompanyAccount getOneJobbyID(int id) {
       return iJobRepo.joinCompanyAndJobAndAccountbyid(id);
    }
}
