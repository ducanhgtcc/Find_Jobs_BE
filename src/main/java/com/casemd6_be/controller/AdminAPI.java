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
@RequestMapping("/admin")
public class AdminAPI {
    @Autowired
    JobService jobService;

    // Admin Job, Active, blog Job
    @GetMapping("/showAdminJob")
    public ResponseEntity<List<ListJobCompanyAccount>> getAdminJob() {
        return new ResponseEntity<>(jobService.getAdminJob(), HttpStatus.OK);
    }

    @GetMapping("blogJob/{id}")
    public ResponseEntity<?> AdminBlockJob(@PathVariable int id) {
        Job job =  jobService.findJobById(id);
        int value = 2;  //Khóa
        int value2 = 1; // Mở
        if (job.getStatus() == 1) {
            job.setStatus(value);
            jobService.save(job);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            job.setStatus(value2);
            jobService.save(job);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
