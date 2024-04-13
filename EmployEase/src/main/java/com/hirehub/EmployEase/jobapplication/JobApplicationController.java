package com.hirehub.EmployEase.jobapplication;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/job_applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @PostMapping("")
    public ResponseEntity<JobApplication> createJobApplication(@RequestHeader("Authorization") String jwt,
    @RequestBody JobApplication jobApplication, @RequestParam String emailId) throws Exception {
        JobApplication createdJobApplication = jobApplicationService.createJobApplication(jobApplication,emailId);
        return new ResponseEntity<>(createdJobApplication, HttpStatus.CREATED);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<JobApplication>> getAllJobApplicationsForJob(@RequestHeader("Authorization") String jwt,@PathVariable Long jobId) {
        List<JobApplication> jobApplications = jobApplicationService.getAllJobApplicationsForJob(jobId);
        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
    }

    @GetMapping("/user/{userEmail}")
    public ResponseEntity<List<JobApplication>> getAllJobApplicationsForUser(@RequestHeader("Authorization") String jwt,@PathVariable String userEmail) {
        List<JobApplication> jobApplications = jobApplicationService.getAllJobApplicationsForUser(userEmail);
        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
    }

    @GetMapping("/{jobApplicationId}")
    public ResponseEntity<JobApplication> getJobApplicationById(@RequestHeader("Authorization") String jwt,@PathVariable String jobApplicationId) {
        JobApplication jobApplication = jobApplicationService.getJobApplicationById(jobApplicationId);
        if (jobApplication != null) {
            return new ResponseEntity<>(jobApplication, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<JobApplication> updateJobApplication(@RequestHeader("Authorization") String jwt,@RequestBody JobApplication jobApplication) {
        JobApplication updatedJobApplication = jobApplicationService.updateJobApplication(jobApplication);
        return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
    }

    @DeleteMapping("/{jobApplicationId}")
    public ResponseEntity<Void> deleteJobApplication(@RequestHeader("Authorization") String jwt,@PathVariable String jobApplicationId) {
        jobApplicationService.deleteJobApplication(jobApplicationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
