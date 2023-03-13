package com.casemd6_be.service;

import com.casemd6_be.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {
    @Autowired
    IAccountRepo iAccountRepo;
}
