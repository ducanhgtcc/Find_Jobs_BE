package com.casemd6_be.controller;

import com.casemd6_be.model.Job;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/job")
public class JobAPI {
    @Autowired
    JobService jobService;

    @GetMapping("/showJob/{email}")
    public ResponseEntity<List<ListJobCompanyAccount>> getAllJobByEmail(@PathVariable String email) {
       return new ResponseEntity<>(jobService.getAllJobByEmail(email),HttpStatus.OK);
    }

    @GetMapping("/block/{id}")
    public ResponseEntity<Job> blockJobByEmail(@PathVariable int id) {
        Job job = jobService.findJobById(id);
        if (job.isStatus()) {
            job.setStatus(false);
        } else {
            job.setStatus(true);
        }
        jobService.save(job);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
