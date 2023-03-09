package com.casemd6_be.service;

import com.casemd6_be.model.Job;
import com.casemd6_be.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    IJobRepo iJobRepo;
    public List<Job> getAllJob() {
        return (List<Job>) iJobRepo.findAll();
    }
}
