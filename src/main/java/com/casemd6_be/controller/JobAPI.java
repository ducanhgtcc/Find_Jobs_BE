package com.casemd6_be.controller;

import com.casemd6_be.model.*;
import com.casemd6_be.model.query.CompanyAndAccount;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.service.CategoryService;
import com.casemd6_be.service.CompanyService;
import com.casemd6_be.service.JobService;
import com.casemd6_be.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/job")
public class JobAPI {
    @Autowired
    JobService jobService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    LocationService locationService;

    @Autowired
    CompanyService companyService;

    @GetMapping("/showJob/{email}")
    public ResponseEntity<List<ListJobCompanyAccount>> getAllJobByEmail(@PathVariable String email) {
        return new ResponseEntity<>(jobService.getAllJobByEmail(email), HttpStatus.OK);
    }

//    @GetMapping("/block/{id}")
//    public ResponseEntity<Job> blockJobByEmail(@PathVariable int id) {
//        Job job = jobService.findJobById(id);
//        if (job.isStatus()) {
//            job.setStatus(false);
//        } else {
//            job.setStatus(true);
//        }
//        jobService.save(job);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/showJobNew")
    public ResponseEntity<List<ListJobCompanyAccount>> getAllJob_Latest() {
        return new ResponseEntity<>(jobService.getAllJob_Latest(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findById(@PathVariable int id) {
        return new ResponseEntity<>(jobService.findById(id), HttpStatus.OK);
    }
    @PostMapping("/{email}")
    public ResponseEntity<Job> creatJob(@RequestBody Job job,@PathVariable String email) {
        CompanyAndAccount company = companyService.getAllCompany(email);
        Company company1 = companyService.findOne(company.getIdCompany());
        String code = company.getCode();
        job.setCode("CODE" + code + company.getIdCompany());
        job.setCompany(company1);
        job.setStatus(1);
        jobService.save(job);
        return new ResponseEntity<>(job, HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity<Job> editJob(@RequestBody Job job) {
        jobService.save(job);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/showJobNew/{id}")
    public ResponseEntity<ListJobCompanyAccount> getOneJob(@PathVariable int id) {
        return new ResponseEntity<>(jobService.getOneJobbyID(id), HttpStatus.OK);
    }

    @GetMapping("/searchCompany/{short_name}")
    public ResponseEntity<List<ListJobCompanyAccount>> searchByCompany(@PathVariable String short_name) {
        return new ResponseEntity<>(jobService.searchByCompany('%' + short_name + '%'), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
    }
    @GetMapping("/location")
    public ResponseEntity<List<Location>> getAllLocation() {
        return new ResponseEntity<>(locationService.getAllLocation(), HttpStatus.OK);
    }
    @GetMapping("/quantity/{idCompany}")
    public ResponseEntity<Iterable<Job>> findAllJobsInCompany(@PathVariable Long idCompany) {
        return new ResponseEntity<>(jobService.findAllJobsInCompanyId(idCompany), HttpStatus.OK);

    }
}
