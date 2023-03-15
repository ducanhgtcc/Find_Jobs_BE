package com.casemd6_be.repository;

import com.casemd6_be.model.Job;
import com.casemd6_be.model.query.ListJobCompanyAccount;
import com.casemd6_be.model.query.ListTopCompany;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import javax.websocket.server.PathParam;
import java.util.List;

public interface IJobRepo extends CrudRepository<Job, Integer> {
    @Query(nativeQuery = true, value = "select job.id as idJob,account.address ,job.code as codeJob,job.description as descriptionJob,exp_year, expired_date,gender,\n" +
            "quantity,salary_min as min,salary_max as max,job.status as statusJob,title,company.code as codeCompany,google_map,number_of_employees,\n" +
            "short_name,website,avatar,banner,account.description as descriptionAcc,email,account.name as nameAcc,phone,account.status as statusAcc,\n" +
            "category.name as nameCategory, location.name as nameLocation\n" +
            "from job join company on company.id = job.company_id\n" +
            "join account on company.account_id=account.id\n" +
            "join category on category.id = job.category_id\n" +
            "join location on location.id = job.location_id where Job.status = 1;")
    List<ListJobCompanyAccount> joinCompanyAndJobAndAccount();

    @Query(nativeQuery = true, value = "select job.id as idJob,account.address ,job.code as codeJob,job.description as descriptionJob,exp_year, expired_date,gender,\n" +
            "quantity,salary_min as min,salary_max as max,job.status as statusJob,title,company.code as codeCompany,google_map,number_of_employees,\n" +
            "short_name,website,avatar,banner,account.description as descriptionAcc,email,account.name as nameAcc,phone,account.status as statusAcc,\n" +
            "category.name as nameCategory, location.name as nameLocation\n" +
            "from job join company on company.id = job.company_id\n" +
            "join account on company.account_id=account.id\n" +
            "join category on category.id = job.category_id\n" +
            "join location on location.id = job.location_id where Job.id=:id")
    ListJobCompanyAccount joinCompanyAndJobAndAccountbyid(@PathParam("id") int id);

    @Query(nativeQuery = true, value = "select job.id as idJob,account.address ,job.code as codeJob,job.description as descriptionJob,exp_year, expired_date,gender,\n" +
            "quantity,salary_min as min,salary_max as max,job.status as statusJob,title,company.code as codeCompany,google_map,number_of_employees,\n" +
            "short_name,website,avatar,banner,account.description as descriptionAcc,email,account.name as nameAcc,phone,account.status as statusAcc,\n" +
            "category.name as nameCategory, location.name as nameLocation\n" +
            "from job join company on company.id = job.company_id\n" +
            "join account on company.account_id=account.id\n" +
            "join category on category.id = job.category_id\n" +
            "join location on location.id = job.location_id \n" +
            "where company.short_name like :short_name ")
    List<ListJobCompanyAccount> searchByCompany(@PathParam("short_name") String short_name);


    @Query(nativeQuery = true,value = "select job.id as idJob,account.address ,job.code as codeJob,job.description as descriptionJob,exp_year, expired_date,gender,\n" +
            "quantity,salary_min as min,salary_max as max,job.status as statusJob,title,company.code as codeCompany,google_map,number_of_employees,\n" +
            "short_name,website,avatar,banner,account.description as descriptionAcc,email,account.name as nameAcc,phone,account.status as statusAcc,\n" +
            "category.name as nameCategory, location.name as nameLocation\n" +
            "from job join company on company.id = job.company_id\n" +
            "join account on company.account_id=account.id\n" +
            "join category on category.id = job.category_id\n" +
            "join location on location.id = job.location_id where email =:email")
    List<ListJobCompanyAccount> joinCompanyAndJobAndAccountByEmail(@Param("email") String email);

    Job findJobsById(int id);

    @Query(nativeQuery = true, value = "select company_id, short_name, avatar, sum(quantity) as sum_quantity from job \n" +
            "left join company on company_id = company.id \n" +
            "join account on account.id = company.account_id\n" +
            "group by company_id order by sum(quantity) desc\n" +
            "limit 6")
    List<ListTopCompany> joinCompanyAndJobAndAccount1();
}
