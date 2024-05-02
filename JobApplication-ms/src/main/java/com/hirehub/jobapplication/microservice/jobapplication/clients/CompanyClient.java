package com.hirehub.jobapplication.microservice.jobapplication.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hirehub.jobapplication.microservice.jobapplication.external.Company;

@FeignClient(name= "COMPANY-SERVICE",url="http://companyms:8081")
public interface CompanyClient {

    @GetMapping("/api/companies/{id}")
    Company getCompany(@PathVariable("id") Long id);

}
