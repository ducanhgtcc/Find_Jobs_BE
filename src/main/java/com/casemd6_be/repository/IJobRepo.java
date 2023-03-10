package com.casemd6_be.repository;

import com.casemd6_be.model.Job;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.websocket.server.PathParam;
import java.util.List;

public interface IJobRepo extends CrudRepository<Job, Integer> {
  @Query(nativeQuery = true,value = "select job.id as idJob,account.address ,job.code as codeJob,job.description as descriptionJob,exp_year, expired_date,gender,\n" +
          "quantity,salary_min as min,salary_max as max,job.status as statusJob,title,company.code as codeCompany,google_map,number_of_employees,\n" +
          "short_name,website,avatar,banner,account.description as descriptionAcc,email,account.name as nameAcc,phone,account.status as statusAcc,\n" +
          "category.name as nameCategory, location.name as nameLocation\n" +
          "from job join company on company.id = job.company_id\n" +
          "join account on company.account_id=account.id\n" +
          "join category on category.id = job.category_id\n" +
          "join location on location.id = job.location_id;")
    List<ListJobCompanyAccount> joinCompanyAndJobAndAccount();

  @Query(nativeQuery = true,value = "select job.id as idJob,account.address ,job.code as codeJob,job.description as descriptionJob,exp_year, expired_date,gender,\n" +
          "quantity,salary_min as min,salary_max as max,job.status as statusJob,title,company.code as codeCompany,google_map,number_of_employees,\n" +
          "short_name,website,avatar,banner,account.description as descriptionAcc,email,account.name as nameAcc,phone,account.status as statusAcc,\n" +
          "category.name as nameCategory, location.name as nameLocation\n" +
          "from job join company on company.id = job.company_id\n" +
          "join account on company.account_id=account.id\n" +
          "join category on category.id = job.category_id\n" +
          "join location on location.id = job.location_id where Job.id=:id" )
  ListJobCompanyAccount joinCompanyAndJobAndAccountbyid(@PathParam("id") int id);


}
