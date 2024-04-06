package com.hirehub.EmployEase.job;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class JobController {

	private JobService jobService;
	
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> findAll()
	{
		return ResponseEntity.ok((jobService.findAll()));
	}
	
	@PostMapping("/jobs")
	public ResponseEntity<Job> createJob(@RequestBody Job job)
	{
		jobService.createJob(job);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id)
	{
       Job job = jobService.findById(id);
	   if(job!=null)
	   return new ResponseEntity<>(job,HttpStatus.OK);
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/jobs/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable Long id)
	{
		boolean deleted = jobService.deleteJobById(id);
		if(deleted)
		return new ResponseEntity<>("Job not found!",HttpStatus.NOT_FOUND);
		return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
	}

	@PutMapping("/jobs/{id}")
	public ResponseEntity<String> updateJobById(@PathVariable Long id,
	@RequestBody Job updatedJob)
	{
		boolean updated = jobService.updateJobById(id,updatedJob);
		if(updated)
		return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
		return new ResponseEntity<>("Job not found!",HttpStatus.NOT_FOUND);
	}
}
