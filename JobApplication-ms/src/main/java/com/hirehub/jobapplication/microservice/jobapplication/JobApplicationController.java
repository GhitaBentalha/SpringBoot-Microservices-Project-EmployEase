package com.hirehub.jobapplication.microservice.jobapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/job_applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @PostMapping("")
    public ResponseEntity<JobApplication> createJobApplication(@RequestParam Long userId, @RequestParam Long jobId) throws Exception {
        JobApplication createdJobApplication = jobApplicationService.createJobApplication(userId,jobId);
        return new ResponseEntity<>(createdJobApplication, HttpStatus.CREATED);
    }

    @GetMapping("/job")
    public ResponseEntity<List<JobApplication>> getAllJobApplicationsForJob(@RequestParam Long jobId) {
        List<JobApplication> jobApplications = jobApplicationService.getAllJobApplicationsForJob(jobId);
        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<JobApplication>> getAllJobApplicationsForUser(@RequestParam Long userId) {
        List<JobApplication> jobApplications = jobApplicationService.getAllJobApplicationsForUser(userId);
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

    @PutMapping
    public ResponseEntity<JobApplication> updateJobApplication(@RequestBody JobApplication jobApplication) {
        JobApplication updatedJobApplication = jobApplicationService.updateJobApplication(jobApplication);
        return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
    }

    @DeleteMapping("/{jobApplicationId}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable String jobApplicationId) {
        jobApplicationService.deleteJobApplication(jobApplicationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
