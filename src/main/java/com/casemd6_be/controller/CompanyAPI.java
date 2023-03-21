package com.casemd6_be.controller;

import com.casemd6_be.model.Account;
import com.casemd6_be.model.Company;
import com.casemd6_be.model.Role;
import com.casemd6_be.model.dto.UpImage;
import com.casemd6_be.model.query.CompanyAndAccount;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.repository.ICompanyRepo;
import com.casemd6_be.service.AccountService;
import com.casemd6_be.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/company")
public class CompanyAPI {
    @Autowired
    CompanyService companyService;

    @Autowired
    AccountService accountService;

    @PostMapping
    public ResponseEntity<Company> editCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/upImg")
    public UpImage upImg(@RequestParam MultipartFile fileImg) {
        String nameImg = fileImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileImg.getBytes(), new File("E:\\Case_Modul6\\find_jobs_FE\\find_jobs_FE\\src\\assets\\client\\img\\" + nameImg));
            return new UpImage("assets/img/" + nameImg) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/showCompany/{email}")
    public ResponseEntity<CompanyAndAccount> getAllJob(@PathVariable String email) {
        return new ResponseEntity<>(companyService.getAllCompany(email),HttpStatus.OK);
    }

}
