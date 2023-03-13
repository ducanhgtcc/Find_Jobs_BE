package com.casemd6_be.controller;

import com.casemd6_be.model.Account;
import com.casemd6_be.model.dto.AccountToken;
import com.casemd6_be.service.AccountService;
import com.casemd6_be.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginAPI {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    AccountService accountService;
    @PostMapping
    public AccountToken login(@RequestBody Account account) {
        // tạo ra 1 đối tượng xác thực
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getEmail(), account.getPassword())
        );
        // nơi chứa đối tượng đang đăng nhập
        // truyền đối tượng đăng nhập vào securityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // tạo ra token
        String token = jwtService.createToken(authentication);
        Account account1 = accountService.findAccountByUsername(account.getEmail());
        return new AccountToken(account1.getId(), account1.getEmail(), account1.getRole(),token);
    }
}

