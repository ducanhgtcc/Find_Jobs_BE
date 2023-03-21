package com.casemd6_be.repository;

import com.casemd6_be.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ICategoryRepo extends CrudRepository<Category, Integer> {

}
