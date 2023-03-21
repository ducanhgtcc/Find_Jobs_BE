package com.casemd6_be.controller;

import com.casemd6_be.model.Account;
import com.casemd6_be.model.Company;
import com.casemd6_be.model.Role;
import com.casemd6_be.model.query.CompanyAndAccount;
import com.casemd6_be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountAPI {
    @Autowired
    AccountService accountService;

    @GetMapping("")
    @PostMapping
    public ResponseEntity<Account> editAccount(@RequestBody Account account){
        Account account1 = accountService.findAccountByUsername(account.getEmail());
        if (accountService.findAccountByPhone(account.getPhone()) == null || Objects.equals(account.getPhone(), account1.getPhone()))
         {
            accountService.save(account);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }



}
