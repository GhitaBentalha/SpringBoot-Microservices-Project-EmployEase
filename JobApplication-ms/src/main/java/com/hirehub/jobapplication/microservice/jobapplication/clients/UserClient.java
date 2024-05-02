package com.hirehub.jobapplication.microservice.jobapplication.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hirehub.jobapplication.microservice.jobapplication.external.User;

@FeignClient(name= "USER-SERVICE")
public interface UserClient {

    @GetMapping("api/users/profile/{id}")
    User findUserId(@PathVariable Long id);

}
