package com.hirehub.jobapplication.microservice.jobapplication;

import java.util.List;

import com.hirehub.jobapplication.microservice.jobapplication.dto.JobApplicationDto;

public interface JobApplicationService {

    JobApplication createJobApplication(Long userId, Long jobId, Long companyId) throws Exception;

    JobApplication updateJobApplicationStatus(String jobApplicationId, JOB_APPLICATION_STATUS status);

    JobApplication updateJobApplication(JobApplication jobApplication);

    List<JobApplicationDto> getAllJobApplicationsForJob(Long jobId);

    List<JobApplicationDto> getAllJobApplicationsForUser(Long userId);

    JobApplicationDto getJobApplicationById(String jobApplicationId);

    void deleteJobApplication(String jobApplicationId);
}
