package com.casemd6_be.controller.Job;

import com.casemd6_be.model.Job;
import com.casemd6_be.model.dto.JobDto;
import com.casemd6_be.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/jobs")
public class JobAPI {
    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAll() {
        return jobService.getAll();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Job> findJobById(@PathVariable int id) {
        return new ResponseEntity<>(jobService.findJobById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> save(@RequestBody Job job) {
        return new ResponseEntity<Job>(jobService.createJob(job),HttpStatus.CREATED);
    }


    @PutMapping({"edit/{id}"})
    public ResponseEntity<Job> edit(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PostMapping({"create"})
    public ResponseEntity<Job> create(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        jobService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/lock/{id}")
    public ResponseEntity<?> lockJob(@PathVariable int id) {
        Job job = jobService.findJobById(id);
        if (job.isStatus()) {
            job.setStatus(false);
        } else {
            job.setStatus(true);
        }
        return new ResponseEntity<>(jobService.createJob(job), HttpStatus.OK);
    }

//    @PutMapping("/lock/{id}")
//    public ResponseEntity<?> lockJobMeta(@PathVariable int id) {
//        JobDto jobDto = jobService.showAllJobMetaData().get(id);
//        if (jobDto.getStatus()) {
//            jobDto.setStatus(false);
//        } else {
//            jobDto.setStatus(true);
//        }
//        return new ResponseEntity<>(jobService.createJob(), HttpStatus.OK);
//    }

    @GetMapping("/jobmeta")
    public ResponseEntity<List<JobDto>> getJobMetas(){
        return new ResponseEntity<>(jobService.showAllJobMetaData(),HttpStatus.OK);
    }


}

