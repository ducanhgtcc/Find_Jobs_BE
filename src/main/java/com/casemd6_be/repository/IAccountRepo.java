package com.casemd6_be.repository;

import com.casemd6_be.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IAccountRepo extends CrudRepository<Account, Integer> {
    Account findAccountByEmail(String email);
    Account findAccountsByPhone(String phone);

}
