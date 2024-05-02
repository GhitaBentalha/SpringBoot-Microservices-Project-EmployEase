package com.hirehub.job.microservice.job.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hirehub.job.microservice.job.external.Company;

@FeignClient(name= "COMPANY-SERVICE",url="http://companyms:8081")
public interface CompanyClient {

    @GetMapping("/api/companies/{id}")
    Company getCompany(@PathVariable("id") Long id);

}
