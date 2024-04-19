package com.hirehub.jobapplication.microservice.jobapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/job_applications")
public class AdminJobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    
    @PutMapping("/{jobApplicationId}/status")
    public ResponseEntity<JobApplication> updateJobApplicationStatus(@PathVariable String jobApplicationId,
        @RequestParam JOB_APPLICATION_STATUS status) {
        JobApplication updatedJobApplication = jobApplicationService.updateJobApplicationStatus(jobApplicationId, status);
        return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
    }
    
}
