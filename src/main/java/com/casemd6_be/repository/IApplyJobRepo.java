package com.casemd6_be.repository;

import com.casemd6_be.model.Account;
import com.casemd6_be.model.ApplyJob;
import com.casemd6_be.model.Job;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IApplyJobRepo extends CrudRepository<ApplyJob, Integer> {

    List<ApplyJob> findApplyJobByAccount_Id(int id);



}
