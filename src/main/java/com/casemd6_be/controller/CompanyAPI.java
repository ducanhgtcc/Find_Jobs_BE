package com.casemd6_be.controller;

import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/company")
public class CompanyAPI {
    @Autowired
    CompanyService companyService;

//    @PostMapping("/editCompany")
//    public ResponseEntity<ListJobCompanyAccount> editPostEnterprise(@RequestBody ListJobCompanyAccount listJobCompanyAccount) {
//        companyService.editCompany(listJobCompanyAccount);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
