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

import com.hirehub.jobapplication.microservice.jobapplication.dto.JobApplicationDto;


@RestController
@RequestMapping("/api/job_applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @PostMapping("")
    public ResponseEntity<JobApplication> createJobApplication(@RequestParam Long userId, @RequestParam Long jobId, @RequestParam Long companyId) throws Exception {
        JobApplication createdJobApplication = jobApplicationService.createJobApplication(userId,jobId, companyId);
        return new ResponseEntity<>(createdJobApplication, HttpStatus.CREATED);
    }

    @GetMapping("/job")
    public ResponseEntity<List<JobApplicationDto>> getAllJobApplicationsForJob(@RequestParam Long jobId) {
        List<JobApplicationDto> jobApplicationDto = jobApplicationService.getAllJobApplicationsForJob(jobId);
        return new ResponseEntity<>(jobApplicationDto, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<JobApplicationDto>> getAllJobApplicationsForUser(@RequestParam Long userId) {
        List<JobApplicationDto> jobApplicationDto = jobApplicationService.getAllJobApplicationsForUser(userId);
        return new ResponseEntity<>(jobApplicationDto, HttpStatus.OK);
    }

    @GetMapping("/{jobApplicationId}")
    public ResponseEntity<JobApplicationDto> getJobApplicationById(@PathVariable Long jobApplicationId) {
        JobApplicationDto jobApplicationDto = jobApplicationService.getJobApplicationById(jobApplicationId);
        if (jobApplicationDto != null) {
            return new ResponseEntity<>(jobApplicationDto, HttpStatus.OK);
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
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long jobApplicationId) {
        jobApplicationService.deleteJobApplication(jobApplicationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
