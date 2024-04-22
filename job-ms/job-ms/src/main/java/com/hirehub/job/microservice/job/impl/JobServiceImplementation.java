package com.hirehub.job.microservice.job.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.hirehub.job.microservice.job.JOB_STATUS;
import com.hirehub.job.microservice.job.Job;
import com.hirehub.job.microservice.job.JobRepository;
import com.hirehub.job.microservice.job.JobService;
import com.hirehub.job.microservice.job.clients.CompanyClient;
import com.hirehub.job.microservice.job.clients.ReviewClient;
import com.hirehub.job.microservice.job.dto.JobDTO;
import com.hirehub.job.microservice.job.external.Company;
import com.hirehub.job.microservice.job.external.Review;
import com.hirehub.job.microservice.job.mapper.JobMapper;

@Service
public class JobServiceImplementation implements JobService {

   private JobRepository jobRepository;

   private CompanyClient companyClient;
   private ReviewClient reviewClient;
   
    public JobServiceImplementation(JobRepository jobRepository, CompanyClient companyClient, ReviewClient reviewClient) {
    this.jobRepository = jobRepository;
    this.companyClient = companyClient;
    this.reviewClient = reviewClient;
}

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(this::convertToDto)
        .collect(Collectors.toList());
    }

    private JobDTO convertToDto(Job job)
    {
        Company company = companyClient.getCompany(job.getCompanyId());
        List<Review> reviews = reviewClient.getReviews(job.getCompanyId());
        Double averageRating =reviewClient.getAverageRating(job.getCompanyId());
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
                if(updatedJob.getWorkMode()!=null)
                {
                    job.setWorkMode(updatedJob.getWorkMode());
                }
                if(updatedJob.getKeySkills()!=null)
                {
                    job.setKeySkills(updatedJob.getKeySkills());
                }
                if(updatedJob.getJobType()!=null)
                {
                    job.setJobType(updatedJob.getJobType());
                }
                jobRepository.save(job);
                return true;
            }  
        }
       return false;
    }

    @Override
    public Job createJob(Job job,Long companyId) {
        job.setCompanyId(companyId);
        jobRepository.save(job);
        return job;
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

    @Override
    public boolean updateJobStatus(Long id, JOB_STATUS status) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent())
        {
            Job job = jobOptional.get();
            job.setStatus(status);
            return true;
        }
        return false;
    }
}
