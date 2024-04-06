package com.hirehub.EmployEase.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
	void createJob(Job job);
    Job findById(Long id);
    Job deleteJobById(Long id);
    boolean updateJobById(Long id, Job updatedJob);
}

