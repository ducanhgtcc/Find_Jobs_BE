package com.casemd6_be.service;

import com.casemd6_be.model.Account;
import com.casemd6_be.model.Company;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.repository.IAccountRepo;
import com.casemd6_be.repository.ICompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    ICompanyRepo iCompanyRepo;

    @Autowired
    IAccountRepo iAccountRepo;



//    public void editCompany(ListJobCompanyAccount listJobCompanyAccount) {
////        iAccountRepo.editAccount(listJobCompanyAccount.getNameAcc(),listJobCompanyAccount.getAddress(),listJobCompanyAccount.getPhone(),listJobCompanyAccount.getBanner(),listJobCompanyAccount.getDescriptionAcc(),listJobCompanyAccount.getEmail());
//        iCompanyRepo.editCompany(listJobCompanyAccount.getGoogle_map(),listJobCompanyAccount.getNumber_of_employees(),listJobCompanyAccount.getShort_name(),listJobCompanyAccount.getWebsite(),listJobCompanyAccount.getEmail());
//    }

    public void createCompany(Company company) {
        iCompanyRepo.save(company);
    }
}
