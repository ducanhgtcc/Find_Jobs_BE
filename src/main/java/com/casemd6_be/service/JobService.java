package com.casemd6_be.service;

import com.casemd6_be.model.Company;
import com.casemd6_be.model.Job;
import com.casemd6_be.model.dto.JobDto;
import com.casemd6_be.repository.ICompanyRepo;
import com.casemd6_be.repository.IJobRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class JobService {
    @Autowired
    private IJobRepo jobRepo;
    @Autowired
    private ICompanyRepo companyRepo;
    @Autowired
    private ModelMapper modelMapper;

    public List<Job> getAll() {
        return jobRepo.findAll();
    }

    public Job findJobById(int id) {
        return jobRepo.findById(id).get();
    }

    public Job createJob(Job job) {
        return jobRepo.save(job);
    }


    public void delete(int id) {
        jobRepo.deleteById(id);
    }

    public List<JobDto> showAllJobMetaData() {
        TypeMap<Company, JobDto> typeMap = modelMapper.createTypeMap(Company.class, JobDto.class)
                .addMapping(Company::getShortName, JobDto::setCompanyShortName)

                ;
        return jobRepo.findAll().stream().map(job -> modelMapper.map(job, JobDto.class)).collect(Collectors.toList());
    }



}
