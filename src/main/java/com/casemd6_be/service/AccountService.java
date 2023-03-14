package com.casemd6_be.service;

import com.casemd6_be.model.Account;
import com.casemd6_be.model.Role;
import com.casemd6_be.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    IAccountRepo iAccountRepo;

    public List<Account> showAll() {
        return (List<Account>) iAccountRepo.findAll();
    }

    public void save(Account account) {
        iAccountRepo.save(account);
    }

    public Account findAccountByUsername(String email) {
        return iAccountRepo.findAccountByEmail(email);
    }

    public Account findAccountByPhone(String phone) {
        return iAccountRepo.findAccountsByPhone(phone);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = iAccountRepo.findAccountByEmail(email);
        List<Role> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getEmail(), account.getPassword(), roles);
    }


}

