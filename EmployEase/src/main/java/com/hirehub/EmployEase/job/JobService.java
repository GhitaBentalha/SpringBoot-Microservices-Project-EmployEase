package com.hirehub.EmployEase.job;

import java.util.List;

import com.hirehub.EmployEase.company.Company;

public interface JobService {
    List<Job> findAll();
	Job createJob(Job job, Company company);
    Job findJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id, Job updatedJob);
    List<Job> getSpecificJobs(Long companyId, boolean isFullTime,
                 boolean isPartTime,boolean isInternship);
    List<Job> searchJob(String keyword);

}

