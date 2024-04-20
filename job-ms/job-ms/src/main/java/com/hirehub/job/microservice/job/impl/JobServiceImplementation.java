package com.hirehub.job.microservice.job.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hirehub.job.microservice.job.Job;
import com.hirehub.job.microservice.job.JobRepository;
import com.hirehub.job.microservice.job.JobService;
import com.hirehub.job.microservice.job.dto.JobDTO;
import com.hirehub.job.microservice.job.external.Company;
import com.hirehub.job.microservice.job.external.Review;
import com.hirehub.job.microservice.job.mapper.JobMapper;

@Service
public class JobServiceImplementation implements JobService {

   private JobRepository jobRepository;

   @Autowired
   RestTemplate restTemplate;
   
    public JobServiceImplementation(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
}

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(this::convertToDto)
        .collect(Collectors.toList());
    }

    private JobDTO convertToDto(Job job)
    {
        Company company = restTemplate.getForObject("http://COMPANY-SERVICE:8081/api/companies/"+job.getCompanyId(),
         Company.class);
        ResponseEntity<List<Review>> reviewResponse = restTemplate.exchange("http://REVIEW-SERVICE:8083/api/reviews?companyId="+job.getCompanyId(),
                HttpMethod.GET,null,new ParameterizedTypeReference<List<Review>>(){});
        List<Review> reviews = reviewResponse.getBody();
        Double averageRating = restTemplate.getForObject("http://REVIEW-SERVICE:8083/api/reviews/average-rating?companyId="+job.getCompanyId(),
        Double.class);
        JobDTO jobWithCompanyDTO = JobMapper.mapToJobWithCompanyDTO(job, company, reviews,averageRating);
        return jobWithCompanyDTO;
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
    public Job createJob(Job job,Long companyId) {
        Job savedJob = new Job();
        savedJob.setTitle(job.getTitle());
        savedJob.setDescription(job.getDescription());
        savedJob.setJobType(job.getJobType());
        savedJob.setMinSalary(job.getMinSalary());
        savedJob.setMaxSalary(job.getMaxSalary());
        savedJob.setExperience(job.getExperience());
        savedJob.setLocation(job.getLocation());
        savedJob.setCompanyId(companyId);
        jobRepository.save(savedJob);
        return savedJob;
    }

    @Override
    public JobDTO findJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return convertToDto(job);
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
