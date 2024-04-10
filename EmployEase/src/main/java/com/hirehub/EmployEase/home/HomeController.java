package com.hirehub.EmployEase.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String indexPage()
    {
        return "Welcome to EmployEase-Find your Dream Job!!";
    }

}
