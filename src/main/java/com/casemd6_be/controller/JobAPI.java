package com.casemd6_be.controller;

import com.casemd6_be.model.Job;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/job")
public class JobAPI {
    @Autowired
    JobService jobService;

    @GetMapping("/showJob")
    public ResponseEntity<List<Job>> getAllJob() {
        return new ResponseEntity<>(jobService.getAllJob(), HttpStatus.OK);
    }


    @GetMapping("/showJobNew")
    public ResponseEntity<List<ListJobCompanyAccount>>getAllJob_Latest(){
       return new ResponseEntity<>(jobService.getAllJob_Latest(),HttpStatus.OK);

    }

    @GetMapping("/showJobNew/{id}")
    public ResponseEntity<ListJobCompanyAccount> getOneJob(@PathVariable int id){
        return new ResponseEntity<>(jobService.getOneJobbyID(id),HttpStatus.OK);
    }
    @GetMapping("/searchCompany/{short_name}")
    public ResponseEntity<List<ListJobCompanyAccount>> searchByCompany(@PathVariable String short_name ){

        return new ResponseEntity<>(jobService.searchByCompany('%'+short_name+'%'),HttpStatus.OK);
    }
}
