package com.casemd6_be.repository;

import com.casemd6_be.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepo extends CrudRepository<Account, Integer> {
    Account findAccountByEmail(String email);
    Account findAccountsByPhone(String phone);
    Account findAccountById(int id);

}
