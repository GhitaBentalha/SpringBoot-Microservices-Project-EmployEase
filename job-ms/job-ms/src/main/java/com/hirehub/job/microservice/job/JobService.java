package com.hirehub.job.microservice.job;

import java.util.List;

import com.hirehub.job.microservice.job.dto.JobDTO;

public interface JobService {
    List<JobDTO> findAll();
	Job createJob(Job job, Long companyId);
    JobResult findJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id, Job updatedJob);
    List<JobDTO> getSpecificJobs(Long companyId, boolean isFullTime,
                 boolean isPartTime,boolean isInternship);
    List<JobDTO> searchJob(String keyword);
    boolean updateJobStatus(Long id, JOB_STATUS status);

}

