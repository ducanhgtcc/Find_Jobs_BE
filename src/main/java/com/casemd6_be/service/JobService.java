package com.casemd6_be.service;

import com.casemd6_be.model.Job;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.model.query.ListTopCompany;
import com.casemd6_be.repository.IJobRepo;
import com.casemd6_be.repository.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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

    public void save(Job job) {
        iJobRepo.save(job);
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

    public List<ListJobCompanyAccount> getShowAllJob() {
        return iJobRepo.joinCompanyAndJobAndAccount();
    }

    public List<ListTopCompany> gettopCompany() {
        return iJobRepo.joinCompanyAndJobAndAccount1();
    }
}
