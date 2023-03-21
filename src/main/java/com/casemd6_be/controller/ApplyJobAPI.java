package com.casemd6_be.controller;

import com.casemd6_be.model.ApplyJob;
import com.casemd6_be.service.ApplyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/applyJob")
public class ApplyJobAPI {
    @Autowired
    ApplyJobService applyJobService;

    @GetMapping("/{id}")
    public ResponseEntity<ApplyJob> findOneApplyJobById(@PathVariable int id) {
        return new ResponseEntity<>(applyJobService.findOneApplyJobById(id).get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ApplyJob>> findAllApplyJob() {
        return new ResponseEntity<>(applyJobService.findAllApplyJob(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApplyJob> create(@RequestBody ApplyJob applyJob) {
        applyJobService.save(applyJob);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApplyJob> delete(@PathVariable int id) {
        if (!applyJobService.findOneApplyJobById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        applyJobService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Tìm tất cả các job của một người dùng đã apply
    @GetMapping("/account/{id}")
    public ResponseEntity<List<ApplyJob>> findApplyJobByAccount(@PathVariable int id) {
        return new ResponseEntity<>(applyJobService.findApplyJobByAccount(id), HttpStatus.OK);
    }
}
