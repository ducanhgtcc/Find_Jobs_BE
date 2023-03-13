package com.casemd6_be.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class JobDto {
    private String title;
    private String companyShortName;
    private String address;
    private Double salaryMin;
    private Double salaryMax;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"M/d/yy", "dd.MM.yyyy"})
    private Date expiredDate;
    private String description;
    private String gender;
    private int quantity;
    private int expYear;

    public JobDto() {
    }

    public JobDto(String title, String companyShortName, String address, Double salaryMin, Double salaryMax, Date expiredDate,
                  String description, String gender, int quantity, int expYear) {
        this.title = title;
        this.companyShortName = companyShortName;
        this.address = address;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.expiredDate = expiredDate;
        this.description = description;
        this.gender = gender;
        this.quantity = quantity;
        this.expYear = expYear;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyShortName() {
        return companyShortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Double salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Double getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Double salaryMax) {
        this.salaryMax = salaryMax;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }



    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }
}
