package com.casemd6_be.repository;

import com.casemd6_be.model.ApplyJob;
import org.springframework.data.repository.CrudRepository;

public interface IApplyJobRepo extends CrudRepository<ApplyJob, Integer> {
}