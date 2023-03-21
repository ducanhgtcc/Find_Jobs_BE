package com.casemd6_be.service;

import com.casemd6_be.model.Company;
import com.casemd6_be.model.Job;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.repository.IJobRepo;
import com.casemd6_be.repository.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    IJobRepo iJobRepo;
    @Autowired
    private IRoleRepo iRoleRepo;

    public List<ListJobCompanyAccount> getAllJobByEmail(String email) {
        return iJobRepo.joinCompanyAndJobAndAccountByEmail(email);
    }

    public Job findJobById(int id) {
        return iJobRepo.findJobsById(id);
    }

    public Job save(Job job) {
        return iJobRepo.save(job);
    }

    public Job findById(int id) {
        return iJobRepo.findById(id).get();
    }

    public Job createJob(Job job) {
        return iJobRepo.save(job);
    }

    public Optional<Job> findOne(int id) {
        return iJobRepo.findById(id);
    }

    public List<ListJobCompanyAccount> getAllJob_Latest() {
        List<ListJobCompanyAccount> ListJob_Latest = iJobRepo.joinCompanyAndJobAndAccount();
        Collections.reverse(ListJob_Latest);
        return ListJob_Latest;
    }

    public ListJobCompanyAccount getOneJobbyID(int id) {
        return iJobRepo.joinCompanyAndJobAndAccountbyid(id);
    }

    public List<ListJobCompanyAccount> searchByCompany(String short_name) {
        return iJobRepo.searchByCompany(short_name);
    }

    public List<Job> findAllJobsInCompanyId(Long id) {
        return iJobRepo.findJobsByCompanyId(id);
    }

}
