package com.hirehub.EmployEase.dto;

import com.hirehub.EmployEase.company.Company;
import com.hirehub.EmployEase.job.Job;
import com.hirehub.EmployEase.model.User;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class JobApplicationDto {
    @Id
    public String jobApplicationId;
    private Company company;
    private User user;
    private Job job;
    private String status;

}
