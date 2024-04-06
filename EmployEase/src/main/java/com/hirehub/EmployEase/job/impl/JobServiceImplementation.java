package com.hirehub.EmployEase.job.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hirehub.EmployEase.job.Job;
import com.hirehub.EmployEase.job.JobService;

@Service
public class JobServiceImplementation implements JobService {

    private List<Job> jobs = new ArrayList<>();
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }

}
