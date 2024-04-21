package com.hirehub.jobapplication.microservice.jobapplication;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobApplication {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jobApplicationId;
    private Long userId;

    private Long jobId;
    private Long companyId;
   
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Enumerated(EnumType.STRING)
    private JOB_APPLICATION_STATUS status;
    private LocalDateTime appliedDate;

    public Long getJobApplicationId() {
        return jobApplicationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public JobApplication(Long jobApplicationId, Long userId, Long jobId, Long companyId, JOB_APPLICATION_STATUS status,
            LocalDateTime appliedDate) {
        this.jobApplicationId = jobApplicationId;
        this.userId = userId;
        this.jobId = jobId;
        this.companyId = companyId;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    public void setJobApplicationId(Long jobApplicationId) {
        this.jobApplicationId = jobApplicationId;
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
