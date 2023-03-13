package com.casemd6_be.repository;

import com.casemd6_be.model.Company;
import com.casemd6_be.model.query.CompanyAndAccount;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ICompanyRepo extends CrudRepository<Company, Integer> {

    @Query(nativeQuery = true,value = "select account.id as idAccount,address,avatar,banner,description,email,name,password,phone,status,role_id as role,\n" +
            "company.id as idCompany, code,google_map,number_of_employees as quantity,short_name,website\n" +
            "from account join company on company.account_id= account.id\n" +
            "where email =:email")
    CompanyAndAccount joinCompanyAndAccountByEmail(@Param("email") String email);


    // edit Company
//    @Modifying
//    @Transactional
//    @Query(nativeQuery = true, value = "UPDATE company join account on company.account_id=account.id SET google_map=:map, number_of_employees=:number_of_employees,short_name=:short_name,website=:website WHERE email =:email ")
//    void editCompany(@Param("map") String map, @Param("number_of_employees") int number_of_employees, @Param("short_name") String short_name, @Param("website") String website, @Param("email") String email);
//

}
