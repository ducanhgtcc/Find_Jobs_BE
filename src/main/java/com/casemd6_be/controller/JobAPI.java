package com.casemd6_be.controller;

import com.casemd6_be.model.Job;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.model.query.ListTopCompany;
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
        if (job.getStatus() == 1) {
            job.setStatus(0);
        } else if(job.getStatus() == 2){
            job.setStatus(2);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else if(job.getStatus() == 0){
            job.setStatus(1);
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

    @GetMapping("/showAllJob")
    public ResponseEntity<List<ListJobCompanyAccount>> getAllJob() {
        return new ResponseEntity<>(jobService.getShowAllJob(), HttpStatus.OK);
    }

    @GetMapping("/showTopCompany")
    public ResponseEntity<List<ListTopCompany>> getTopCompany() {
        return new ResponseEntity<>(jobService.gettopCompany(), HttpStatus.OK);
    }

    @GetMapping("/guest")
    public ResponseEntity<List<ListJobCompanyAccount>>getallbyGuest(){
        return new ResponseEntity<>(jobService.getAllJob_Latest(),HttpStatus.OK);
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

    // Viết API
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

    //Sort Job by salary
    @GetMapping("/sortJobBySalaryMin")
    public ResponseEntity<List<ListJobCompanyAccount>> sortJobBySalaryMin() {
        return new ResponseEntity<>(jobService.sortJobBySalaryMin(), HttpStatus.OK);
    }

    @GetMapping("/sortJobBySalary1000")
    public ResponseEntity<List<ListJobCompanyAccount>> sortJobBySalary1000() {
        return new ResponseEntity<>(jobService.sortJobBySalary1000(), HttpStatus.OK);
    }

    @GetMapping("/sortJobBySalary2000")
    public ResponseEntity<List<ListJobCompanyAccount>> sortJobBySalary2000() {
        return new ResponseEntity<>(jobService.sortJobBySalary2000(), HttpStatus.OK);
    }

    @GetMapping("/sortJobBySalaryMax")
    public ResponseEntity<List<ListJobCompanyAccount>> sortJobBySalaryMax() {
        return new ResponseEntity<>(jobService.sortJobBySalaryMax(), HttpStatus.OK);
    }
}
