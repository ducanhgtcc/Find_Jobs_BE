package com.casemd6_be.repository;

import com.casemd6_be.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepo extends CrudRepository<Account, Integer> {
    Account findAccountByEmail(String email);
    Account findAccountsByPhone(String phone);
    Account findAccountById(int id);

    // edit Account
//    @Modifying
//    @Query(nativeQuery = true, value = "UPDATE account SET name=:name, address=:address,phone=:phone,banner=:banner,description=:description WHERE email =:email ")
//    void editAccount(@Param("name") String name,@Param("address") String address,@Param("phone") String phone,@Param("banner") String banner,@Param("description") String description,@Param("email") String email);
}
