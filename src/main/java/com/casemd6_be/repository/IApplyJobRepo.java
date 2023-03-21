package com.casemd6_be.repository;

import com.casemd6_be.model.ApplyJob;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IApplyJobRepo extends CrudRepository<ApplyJob, Integer> {
    List<ApplyJob> findApplyJobByAccount_Id(int id);
}
