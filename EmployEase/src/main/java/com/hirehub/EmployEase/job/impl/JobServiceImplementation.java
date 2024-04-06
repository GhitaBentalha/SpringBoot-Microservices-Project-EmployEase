package com.hirehub.EmployEase.job.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hirehub.EmployEase.job.Job;
import com.hirehub.EmployEase.job.JobService;

@Service
public class JobServiceImplementation implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job findById(Long id) {
        for(Job job:jobs)
        {
            if(job.getId()==id)
            return job;
        }
        return null;
    }

    @Override
    public Job deleteJobById(Long id) {
       Job job = findById(id);
      jobs.remove(job);
      return job;
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        for(Job job:jobs)
        {
            if(job.getId()==id)
            {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }  
        }
       return false;
    }
}
