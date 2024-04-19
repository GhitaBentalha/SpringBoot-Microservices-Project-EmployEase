package com.hirehub.jobapplication.microservice.jobapplication;

import java.util.List;

public interface JobApplicationService {

    JobApplication createJobApplication(Long userId, Long jobId) throws Exception;

    JobApplication updateJobApplicationStatus(String jobApplicationId, JOB_APPLICATION_STATUS status);

    JobApplication updateJobApplication(JobApplication jobApplication);

    List<JobApplication> getAllJobApplicationsForJob(Long jobId);

    List<JobApplication> getAllJobApplicationsForUser(Long userId);

    JobApplication getJobApplicationById(String jobApplicationId);

    void deleteJobApplication(String jobApplicationId);
}
