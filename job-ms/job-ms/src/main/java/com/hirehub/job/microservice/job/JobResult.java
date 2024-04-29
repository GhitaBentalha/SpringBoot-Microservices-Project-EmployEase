package com.hirehub.job.microservice.job;

import com.hirehub.job.microservice.job.dto.JobDTO;

public class JobResult {
    private JobDTO jobDTO;
    private String message;

    public JobResult(JobDTO jobDTO) {
        this.jobDTO = jobDTO;
    }

    public JobResult(String message) {
        this.message = message;
    }

    public JobDTO getJobDTO() {
        return jobDTO;
    }

    public String getMessage() {
        return message;
    }

    public boolean isJobDTO() {
        return jobDTO != null;
    }

    public boolean isMessage() {
        return message != null;
    }
}
