package com.hirehub.EmployEase.jobapplication;

import java.time.LocalDateTime;

import com.hirehub.EmployEase.alluser.User;
import com.hirehub.EmployEase.job.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class JobApplication {

    @Id
    public String jobApplicationId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Job job;
   
    @Enumerated(EnumType.STRING)
    private JOB_APPLICATION_STATUS status;

    public JobApplication(String jobApplicationId, User user, Job job, JOB_APPLICATION_STATUS status,
            LocalDateTime appliedDate) {
        this.jobApplicationId = jobApplicationId;
        this.user = user;
        this.job = job;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    private LocalDateTime appliedDate;

    public String getJobApplicationId() {
        return jobApplicationId;
    }

    public void setJobApplicationId(String jobApplicationId) {
        this.jobApplicationId = jobApplicationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JOB_APPLICATION_STATUS getStatus() {
        return status;
    }

    public JobApplication() {
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
}
