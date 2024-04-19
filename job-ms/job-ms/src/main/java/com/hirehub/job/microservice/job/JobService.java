package com.hirehub.job.microservice.job;

import java.util.List;

import com.hirehub.job.microservice.job.dto.JobWithCompanyDTO;

public interface JobService {
    List<JobWithCompanyDTO> findAll();
	Job createJob(Job job, Long companyId);
    Job findJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id, Job updatedJob);
    List<Job> getSpecificJobs(Long companyId, boolean isFullTime,
                 boolean isPartTime,boolean isInternship);
    List<Job> searchJob(String keyword);

}

