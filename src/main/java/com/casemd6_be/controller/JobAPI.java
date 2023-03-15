package com.casemd6_be.controller;

import com.casemd6_be.model.Job;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/job")
public class JobAPI {
    @Autowired
    JobService jobService;

    @GetMapping("/showJob/{email}")
    public ResponseEntity<List<ListJobCompanyAccount>> getAllJobByEmail(@PathVariable String email) {
       return new ResponseEntity<>(jobService.getAllJobByEmail(email),HttpStatus.OK);
    }

    @GetMapping("/block/{id}")
    public ResponseEntity<Job> blockJobByEmail(@PathVariable int id) {
        Job job = jobService.findJobById(id);
        if (job.isStatus()) {
            job.setStatus(false);
        } else {
            job.setStatus(true);
        }
        jobService.save(job);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/showJobNew")
    public ResponseEntity<List<ListJobCompanyAccount>>getAllJob_Latest(){
       return new ResponseEntity<>(jobService.getAllJob_Latest(),HttpStatus.OK);

    }

    @GetMapping("/showJobNew/{id}")
    public ResponseEntity<ListJobCompanyAccount> getOneJob(@PathVariable int id){
        return new ResponseEntity<>(jobService.getOneJobbyID(id),HttpStatus.OK);
    }



    @GetMapping("/searchCompany/{short_name}")
    public ResponseEntity<List<ListJobCompanyAccount>> searchByCompany(@PathVariable String short_name ){
        return new ResponseEntity<>(jobService.searchByCompany('%'+short_name+'%'),HttpStatus.OK);
    }
    // 7 API search job
    @GetMapping("/searchJobsByTitleOrAddress")
    public ResponseEntity<List<ListJobCompanyAccount>> searchJobsByTitleOrAddress(@RequestParam(name = "key") String key){
        return new ResponseEntity<>(jobService.searchJobsByTitleOrAddress('%' + key + '%'),HttpStatus.OK);
    }


    @GetMapping("/searchJobsByNameCategory")
    public ResponseEntity<List<ListJobCompanyAccount>> searchJobsByNameCategory(@RequestParam(name = "idCategory") int idCategory){
        return new ResponseEntity<>(jobService.searchJobsByNameCategory(idCategory),HttpStatus.OK);
    }

    @GetMapping("/searchJobsByNameLocation")
    public ResponseEntity<List<ListJobCompanyAccount>> searchJobsByNameLocation(@RequestParam(name = "idLocation") int idLocation){
        return new ResponseEntity<>(jobService.searchJobsByNameLocation(idLocation),HttpStatus.OK);
    }

    //viet api
    @GetMapping("/searchJobsByTitleAndAddressAndCategory")
    public ResponseEntity<List<ListJobCompanyAccount>> searchJobsByTitleAndAddressAndCategory(@RequestParam(name = "key") String key, @RequestParam(name = "idCategory")  int idCategory) {
        return new ResponseEntity<>(jobService.searchJobsByTitleAndAddressAndCategory('%' + key + '%', idCategory), HttpStatus.OK);
    }

    @GetMapping("/searchJobsByTitleAndAddressAndLocation")
    public ResponseEntity<List<ListJobCompanyAccount>> searchJobsByTitleAndAddressAndLocation(@RequestParam(name = "key") String key, @RequestParam(name = "idLocation") int idLocation) {
        return new ResponseEntity<>(jobService.searchJobsByTitleAndAddressAndLocation('%' + key + '%', idLocation), HttpStatus.OK);
    }

    @GetMapping("/searchJobsByCategoryAndLocation")
    public ResponseEntity<List<ListJobCompanyAccount>> searchJobsByCategoryAndLocation(@RequestParam(name = "idCategory") int idCategory, @RequestParam(name = "idLocation") int idLocation) {
        return new ResponseEntity<>(jobService.searchJobsByCategoryAndLocation(idCategory, idLocation), HttpStatus.OK);
    }

    @GetMapping("/searchJobsByTitleAddressCategoryLocation")
    public ResponseEntity<List<ListJobCompanyAccount>> searchJobsByTitleAddressCategoryLocation(@RequestParam(name = "key") String key,@RequestParam(name = "idCategory") int idCategory, @RequestParam(name = "idLocation") int idLocation) {
        return new ResponseEntity<>(jobService.searchJobsByTitleAddressCategoryLocation('%' + key + '%',idCategory, idLocation), HttpStatus.OK);
    }

}
