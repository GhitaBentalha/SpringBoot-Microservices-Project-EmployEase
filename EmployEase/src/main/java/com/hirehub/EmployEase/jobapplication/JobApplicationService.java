package com.hirehub.EmployEase.jobapplication;

import java.util.List;

public interface JobApplicationService {

    JobApplication createJobApplication(JobApplication jobApplication);

    JobApplication updateJobApplicationStatus(String jobApplicationId, JOB_APPLICATION_STATUS status);

    JobApplication updateJobApplication(JobApplication jobApplication);

    List<JobApplication> getAllJobApplicationsForJob(Long jobId);

    List<JobApplication> getAllJobApplicationsForUser(String userId);

    JobApplication getJobApplicationById(String jobApplicationId);

    void deleteJobApplication(String jobApplicationId);
}
