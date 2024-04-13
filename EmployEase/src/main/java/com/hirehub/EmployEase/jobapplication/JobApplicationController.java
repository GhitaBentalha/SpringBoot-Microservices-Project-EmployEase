package com.hirehub.EmployEase.jobapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/job_applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<JobApplication>> getAllJobApplicationsForJob(@PathVariable Long jobId) {
        List<JobApplication> jobApplications = jobApplicationService.getAllJobApplicationsForJob(jobId);
        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
    }

    @GetMapping("/user/{userEmail}")
    public ResponseEntity<List<JobApplication>> getAllJobApplicationsForUser(@PathVariable String userEmail) {
        List<JobApplication> jobApplications = jobApplicationService.getAllJobApplicationsForUser(userEmail);
        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
    }

    @GetMapping("/{jobApplicationId}")
    public ResponseEntity<JobApplication> getJobApplicationById(@PathVariable String jobApplicationId) {
        JobApplication jobApplication = jobApplicationService.getJobApplicationById(jobApplicationId);
        if (jobApplication != null) {
            return new ResponseEntity<>(jobApplication, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
