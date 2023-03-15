package com.casemd6_be.service;

import com.casemd6_be.model.Account;
import com.casemd6_be.model.Company;
import com.casemd6_be.model.query.CompanyAndAccount;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.repository.IAccountRepo;
import com.casemd6_be.repository.ICompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    ICompanyRepo iCompanyRepo;


    public void createCompany(Company company) {
        iCompanyRepo.save(company);
    }

    public CompanyAndAccount getAllCompany(String email) {
        return iCompanyRepo.joinCompanyAndAccountByEmail(email);
    }
    public ListJobCompanyAccount getOneCompany(int id){
        return iCompanyRepo.joinCompanyAndJobAndAccountbyid(id);
    }


}
