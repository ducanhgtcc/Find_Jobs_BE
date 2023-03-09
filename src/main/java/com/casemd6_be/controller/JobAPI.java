package com.casemd6_be.controller;

import com.casemd6_be.model.Job;
import com.casemd6_be.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/job")
public class JobAPI {
    @Autowired
    JobService jobService;
    @GetMapping("/showJob")
    public ResponseEntity<List<Job>> getAllJob() {
       return new ResponseEntity<>(jobService.getAllJob(),HttpStatus.OK);
    }
}
