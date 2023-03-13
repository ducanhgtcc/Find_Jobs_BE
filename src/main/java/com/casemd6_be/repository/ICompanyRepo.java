package com.casemd6_be.repository;

import com.casemd6_be.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ICompanyRepo extends JpaRepository<Company, Integer> {
}
