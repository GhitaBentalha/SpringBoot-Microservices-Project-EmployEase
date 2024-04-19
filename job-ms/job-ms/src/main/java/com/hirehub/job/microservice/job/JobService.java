package com.hirehub.job.microservice.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
	Job createJob(Job job, Long companyId);
    Job findJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id, Job updatedJob);
    List<Job> getSpecificJobs(Long companyId, boolean isFullTime,
                 boolean isPartTime,boolean isInternship);
    List<Job> searchJob(String keyword);

}

