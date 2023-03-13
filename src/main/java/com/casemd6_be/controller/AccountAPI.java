package com.casemd6_be.controller;

import com.casemd6_be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountAPI {
    @Autowired
    AccountService accountService;





}
