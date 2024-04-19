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

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jobApplicationId;
    private Long userId;

    private Long jobId;
   
    @Enumerated(EnumType.STRING)
    private JOB_APPLICATION_STATUS status;

    public JobApplication( Long jobApplicationId,Long userId, Long jobId, JOB_APPLICATION_STATUS status,
            LocalDateTime appliedDate) {
        this.jobApplicationId = jobApplicationId;
        this.userId = userId;
        this.jobId = jobId;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    private LocalDateTime appliedDate;

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
