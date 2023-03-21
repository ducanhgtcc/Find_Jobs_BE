package com.casemd6_be.repository;

import com.casemd6_be.model.Category;
import com.casemd6_be.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ILocationRepo extends CrudRepository<Location, Integer> {


}
