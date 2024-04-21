package com.hirehub.jobapplication.microservice.jobapplication.dto;

import java.time.LocalDateTime;

import com.hirehub.jobapplication.microservice.jobapplication.JOB_APPLICATION_STATUS;
import com.hirehub.jobapplication.microservice.jobapplication.external.Company;
import com.hirehub.jobapplication.microservice.jobapplication.external.Job;
import com.hirehub.jobapplication.microservice.jobapplication.external.User;

public class JobApplicationDto {

    private Long jobApplicationId;
    private JOB_APPLICATION_STATUS status;
    private LocalDateTime appliedDate;
    private Job job;
    private Company company;
    public Long getJobApplicationId() {
        return jobApplicationId;
    }
    public void setJobApplicationId(Long jobApplicationId) {
        this.jobApplicationId = jobApplicationId;
    }
    public JOB_APPLICATION_STATUS getStatus() {
        return status;
    }
    public void setStatus(JOB_APPLICATION_STATUS status) {
        this.status = status;
    }
    public LocalDateTime getAppliedDate() {
        return appliedDate;
    }
    public void setAppliedDate(LocalDateTime appliedDate) {
        this.appliedDate = appliedDate;
    }
    public Job getJob() {
        return job;
    }
    public void setJob(Job job) {
        this.job = job;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public User getUserProfile() {
        return userProfile;
    }
    public void setUserProfile(User userProfile) {
        this.userProfile = userProfile;
    }
    private User userProfile;

}
