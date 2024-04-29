package com.hirehub.jobapplication.microservice.jobapplication;

import com.hirehub.jobapplication.microservice.jobapplication.dto.JobApplicationDto;

public class JobApplicationResult {
    private JobApplicationDto jobApplicationDto;
    private String message;

    public JobApplicationResult(JobApplicationDto jobApplicationDto) {
        this.jobApplicationDto = jobApplicationDto;
    }

    public JobApplicationResult(String message) {
        this.message = message;
    }

    public JobApplicationDto getApplicationJobDto() {
        return jobApplicationDto;
    }

    public String getMessage() {
        return message;
    }

    public boolean isJobApplicationDto() {
        return jobApplicationDto != null;
    }

    public boolean isMessage() {
        return message != null;
    }
}
