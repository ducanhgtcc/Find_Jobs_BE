package com.casemd6_be.controller;

import com.casemd6_be.model.Account;
import com.casemd6_be.model.Role;
import com.casemd6_be.service.AccountService;
import com.casemd6_be.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class RegisterAPI {

    @Autowired
    AccountService accountService;

    @Autowired
    SendEmailService sendEmailService;

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        return new ResponseEntity<>(accountService.showAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account) {
        Role role = new Role();

        if (accountService.findAccountByUsername(account.getEmail()) == null ||
                accountService.findAccountByPhone(account.getPhone()) == null) {
            role.setId(account.getRole().getId());
            account.setRole(role);
            account.setAvatar("https://i.pinimg.com/236x/16/b2/e2/16b2e2579118bf6fba3b56523583117f.jpg");
            account.setStatus(false);

            sendEmailService.sendMail(account.getEmail(), "Thông báo","Tài khoản "+ account.getName()+ " đã được đăng kí." +
                    "Xin chờ hệ thống xác nhân từ 1 đến 2 ngày");
            accountService.save(account);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
