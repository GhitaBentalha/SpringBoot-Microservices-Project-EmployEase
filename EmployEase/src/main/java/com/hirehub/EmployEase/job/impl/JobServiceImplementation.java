package com.hirehub.EmployEase.job.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hirehub.EmployEase.company.Company;
import com.hirehub.EmployEase.job.Job;
import com.hirehub.EmployEase.job.JobRepository;
import com.hirehub.EmployEase.job.JobService;

@Service
public class JobServiceImplementation implements JobService {

   private JobRepository jobRepository;
    public JobServiceImplementation(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
}

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public boolean deleteJobById(Long id) {
        if(jobRepository.existsById(id))
        {
            jobRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        {
            if(jobOptional.isPresent())
            {
                Job job = jobOptional.get();
                if(updatedJob.getTitle()!=null)
                {
                    job.setTitle(updatedJob.getTitle());
                }
                if(updatedJob.getDescription()!=null)
                {
                    job.setDescription(updatedJob.getDescription());
                }
                if(updatedJob.getMinSalary()!=null)
                {
                job.setMinSalary(updatedJob.getMinSalary());
                }
                if(updatedJob.getMaxSalary()!=null)
                {
                    job.setMaxSalary(updatedJob.getMaxSalary());
                }
                if(updatedJob.getLocation()!=null)
                {
                    job.setLocation(updatedJob.getLocation());
                }
                if(updatedJob.getExperience()!=null)
                {
                    job.setExperience(updatedJob.getExperience());
                }
                jobRepository.save(job);
                return true;
            }  
        }
       return false;
    }

    @Override
    public Job createJob(Job job, Company company) {
        Job savedJob = new Job();
        savedJob.setTitle(job.getTitle());
        savedJob.setDescription(job.getDescription());
        savedJob.setJobType(job.getJobType());
        savedJob.setMinSalary(job.getMinSalary());
        savedJob.setMaxSalary(job.getMaxSalary());
        savedJob.setExperience(job.getExperience());
        savedJob.setLocation(job.getLocation());
        savedJob.setApplicants(job.getApplicants());
        savedJob.setCompany(company);
        jobRepository.save(savedJob);
        company.getJobs().add(savedJob);
        return savedJob;
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public List<Job> getSpecificJobs(Long companyId , boolean isFullTime, boolean isPartTime, boolean isInternship) {
       List<Job> jobs = jobRepository.findByCompanyId(companyId);
       if(isFullTime)
        {
            jobs = filterByFullTime(jobs,isFullTime);    
        }
        if(isPartTime)
        {
            jobs = filterByPartTime(jobs,isPartTime); 
        }
        if(isInternship)
        {
            jobs = filterByInternship(jobs,isInternship); 
        }
        return jobs;
    }

    private List<Job> filterByInternship(List<Job> jobs, boolean isInternship) {
        return jobs.stream().filter(job->job.isInternship()==true).collect(Collectors.toList());
    }

    private List<Job> filterByPartTime(List<Job> jobs, boolean isPartTime) {
        return jobs.stream().filter(job->job.isFullTime()==false).collect(Collectors.toList());
    }

    private List<Job> filterByFullTime(List<Job> jobs, boolean isFullTime) {
        return jobs.stream().filter(job->job.isFullTime()==true).collect(Collectors.toList());
    }

    @Override
    public List<Job> searchJob(String keyword) {
        return jobRepository.searchJob(keyword);
    }
}
