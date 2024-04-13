package com.hirehub.EmployEase.jobapplication;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hirehub.EmployEase.alluser.UserService;
import com.hirehub.EmployEase.job.Job;
import com.hirehub.EmployEase.job.JobRepository;


@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public JobApplication createJobApplication(JobApplication jobApplication, String emailId) throws Exception {
        jobApplication.setStatus(JOB_APPLICATION_STATUS.APPLIED);
        jobApplication.setAppliedDate(LocalDateTime.now());
        jobApplication.setUser(userService.findUserByEmailId(emailId));
        Job job = jobRepository.findById(jobApplication.getJob().getId()).orElse(null);
        jobApplication.setJob(job);
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

    @Override
    public List<JobApplication> getAllJobApplicationsForJob(Long jobId) {
        return jobApplicationRepository.findByJobId(jobId);
    }

    @Override
    public List<JobApplication> getAllJobApplicationsForUser(String userEmail) {
        return jobApplicationRepository.findByUserEmailId(userEmail);
    }

    @Override
    public JobApplication getJobApplicationById(String jobApplicationId) {
        Optional<JobApplication> optionalJobApplication = jobApplicationRepository.findById(jobApplicationId);
        return optionalJobApplication.orElse(null);
    }

    @Override
    public void deleteJobApplication(String jobApplicationId) {
        jobApplicationRepository.deleteById(jobApplicationId);
    }

}
