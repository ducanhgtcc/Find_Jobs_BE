package com.casemd6_be.repository;

import com.casemd6_be.model.Job;
import org.springframework.data.repository.CrudRepository;

public interface IJobRepo extends CrudRepository<Job, Integer> {
}
