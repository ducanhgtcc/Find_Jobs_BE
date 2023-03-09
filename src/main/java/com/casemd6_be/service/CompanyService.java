package com.casemd6_be.service;

import com.casemd6_be.repository.ICompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    ICompanyRepo iCompanyRepo;
}
