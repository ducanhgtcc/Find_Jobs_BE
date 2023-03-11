package com.casemd6_be.repository;

import com.casemd6_be.model.Company;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ICompanyRepo extends CrudRepository<Company, Integer> {

    // edit Company
//    @Modifying
//    @Transactional
//    @Query(nativeQuery = true, value = "UPDATE company join account on company.account_id=account.id SET google_map=:map, number_of_employees=:number_of_employees,short_name=:short_name,website=:website WHERE email =:email ")
//    void editCompany(@Param("map") String map, @Param("number_of_employees") int number_of_employees, @Param("short_name") String short_name, @Param("website") String website, @Param("email") String email);
//

}
