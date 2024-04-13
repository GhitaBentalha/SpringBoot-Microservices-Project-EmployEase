package com.hirehub.EmployEase.jobapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/job_applications")
public class AdminJobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @PostMapping("")
    public ResponseEntity<JobApplication> createJobApplication(@RequestBody JobApplication jobApplication, @RequestHeader("Authorization") String jwt) {
        JobApplication createdJobApplication = jobApplicationService.createJobApplication(jobApplication);
        return new ResponseEntity<>(createdJobApplication, HttpStatus.CREATED);
    }
    
    @PutMapping("/{jobApplicationId}/status")
    public ResponseEntity<JobApplication> updateJobApplicationStatus(@PathVariable String jobApplicationId,
        @RequestParam JOB_APPLICATION_STATUS status, @RequestHeader("Authorization") String jwt) {
        JobApplication updatedJobApplication = jobApplicationService.updateJobApplicationStatus(jobApplicationId, status);
        return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<JobApplication> updateJobApplication(@RequestBody JobApplication jobApplication, @RequestHeader("Authorization") String jwt) {
        JobApplication updatedJobApplication = jobApplicationService.updateJobApplication(jobApplication);
        return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
    }

    @DeleteMapping("/{jobApplicationId}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable String jobApplicationId, @RequestHeader("Authorization") String jwt) {
        jobApplicationService.deleteJobApplication(jobApplicationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
