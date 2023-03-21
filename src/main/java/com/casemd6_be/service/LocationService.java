package com.casemd6_be.service;

import com.casemd6_be.model.Location;
import com.casemd6_be.repository.ILocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    ILocationRepo iLocationRepo;
    public List<Location> getAllLocation(){
        return (List<Location>) iLocationRepo.findAll();
    }



}
