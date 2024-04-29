package com.hirehub.jobapplication.microservice.jobapplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hirehub.jobapplication.microservice.jobapplication.clients.CompanyClient;
import com.hirehub.jobapplication.microservice.jobapplication.clients.JobClient;
import com.hirehub.jobapplication.microservice.jobapplication.clients.UserClient;
import com.hirehub.jobapplication.microservice.jobapplication.dto.JobApplicationDto;
import com.hirehub.jobapplication.microservice.jobapplication.external.Company;
import com.hirehub.jobapplication.microservice.jobapplication.external.Job;
import com.hirehub.jobapplication.microservice.jobapplication.external.User;
import com.hirehub.jobapplication.microservice.jobapplication.mapper.JobApplicationMapper;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    UserClient userClient;

    @Autowired
    CompanyClient companyClient;

    @Autowired
    JobClient jobClient;

    @Override
    public JobApplication createJobApplication(Long userId, Long jobId, Long companyId) throws Exception {
        JobApplication jobApplication=new JobApplication();
        jobApplication.setStatus(JOB_APPLICATION_STATUS.APPLIED);
        jobApplication.setAppliedDate(LocalDateTime.now());
        jobApplication.setUserId(userId);
        jobApplication.setJobId(jobId);
        jobApplication.setCompanyId(companyId);
        return jobApplicationRepository.save(jobApplication);
    }

    @Override
    public JobApplication updateJobApplicationStatus(String jobApplicationId, JOB_APPLICATION_STATUS status) {
        Optional<JobApplication> optionalJobApplication = jobApplicationRepository.findById(jobApplicationId);
        if (optionalJobApplication.isPresent()) {
            JobApplication jobApplication = optionalJobApplication.get();
            jobApplication.setStatus(status);
            return jobApplicationRepository.save(jobApplication);
        } else {
            throw new RuntimeException("Job application not found with id: " + jobApplicationId);
        }
    }

    @Override
    public JobApplication updateJobApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    private JobApplicationDto convertToDto(JobApplication jobApplication)
    {
        Job job = jobClient.getJobById(jobApplication.getJobId());
        Company company = companyClient.getCompany(jobApplication.getCompanyId());
        User user = userClient.findUserId(jobApplication.getUserId());
        JobApplicationDto jobApplicationDto = JobApplicationMapper.mapToJobApplicationDto(jobApplication, job, company, user);
        return jobApplicationDto;
    }

    @Override
    @Retry(name = "jobApplicationBreaker", fallbackMethod = "jobApplicationBreaker")
    @CircuitBreaker(name = "jobApplicationBreaker", fallbackMethod = "jobApplicationBreaker")
    @RateLimiter(name = "jobApplicationBreaker", fallbackMethod = "jobApplicationBreaker")
    public List<JobApplicationDto> getAllJobApplicationsForJob(Long jobId) {
        List<JobApplication> jobApplications = jobApplicationRepository.findByJobId(jobId);
        return jobApplications.stream().map(this::convertToDto)
        .collect(Collectors.toList());
    }

      public List<String> jobApplicationBreaker(Throwable throwable) {
        List<String> errList = new ArrayList<>();
        errList.add("😥 Uh-oh! We ran into an issue...The service is currently unavailable. Our team is working on resolving the issue as quickly as possible. Please try again later. 🛠️");
        return errList;
    }

    @Override
    @Retry(name = "jobApplicationBreaker", fallbackMethod = "jobApplicationBreaker")
    @CircuitBreaker(name = "jobApplicationBreaker", fallbackMethod = "jobApplicationBreaker")
    @RateLimiter(name = "jobApplicationBreaker", fallbackMethod = "jobApplicationBreaker")
    public List<JobApplicationDto> getAllJobApplicationsForUser(Long userId) {
        List<JobApplication> jobApplications = jobApplicationRepository.findByUserId(userId);
        return jobApplications.stream().map(this::convertToDto)
        .collect(Collectors.toList());
    }

    @Override
    @Retry(name = "jobApplicationBreaker", fallbackMethod = "jobApplicationBreakerForId")
    @CircuitBreaker(name = "jobApplicationBreaker", fallbackMethod = "jobApplicationBreakerForId")
    @RateLimiter(name = "jobApplicationBreaker", fallbackMethod = "jobApplicationBreakerForId")
    public JobApplicationDto getJobApplicationById(String jobApplicationId) {
        JobApplication jobApplication = jobApplicationRepository.findById(jobApplicationId).orElse(null);
        return convertToDto(jobApplication);
    }

    public JobApplicationResult jobApplicationBreakerForId(Long id, Throwable throwable) {
        String errorMessage = "😥 Uh-oh! We ran into an issue...The service is currently unavailable. Our team is working on resolving the issue as quickly as possible. Please try again later. 🛠️";
        return new JobApplicationResult(errorMessage);
    }    

    @Override
    public void deleteJobApplication(String jobApplicationId) {
        jobApplicationRepository.deleteById(jobApplicationId);
    }

}
