package com.hirehub.jobapplication.microservice.jobapplication.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hirehub.jobapplication.microservice.jobapplication.external.Job;

@FeignClient(name = "JOB-SERVICE")
public interface JobClient {

    @GetMapping("/api/jobs/{id}")
    Job getJobById(@PathVariable Long id);

}
