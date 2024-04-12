package com.hirehub.EmployEase.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hirehub.EmployEase.alluser.User;
import com.hirehub.EmployEase.alluser.UserService;
import com.hirehub.EmployEase.company.Company;
import com.hirehub.EmployEase.company.CompanyService;

@RestController
@RequestMapping("/api/admin/jobs")
public class AdminJobController {

    private JobService jobService;
    private UserService userService;
    private CompanyService companyService;

    public AdminJobController(JobService jobService, UserService userService, CompanyService companyService) {
        this.jobService = jobService;
        this.userService = userService;
        this.companyService = companyService;
    }

    @PostMapping()
	public ResponseEntity<Job> createJob(@RequestBody Job job, @RequestHeader("Authorization") String jwt)
	{
        User user = userService.findUserByJwtToken(jwt);
        Company company = companyService.getCompanyByUserId(user.getId());
		Job savedJob = jobService.createJob(job,company);
		return new ResponseEntity<>(savedJob,HttpStatus.CREATED);
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable Long id, @RequestHeader("Authorization") String jwt)
	{
		boolean deleted = jobService.deleteJobById(id);
		if(deleted)
		{
			return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Job not found!",HttpStatus.NOT_FOUND);
		}
	}

    @PutMapping("/{id}")
	public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestHeader("Authorization") String jwt,
	@RequestBody Job updatedJob)
	{
		boolean updated = jobService.updateJobById(id,updatedJob);
		if(updated)
		return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
		return new ResponseEntity<>("Job not found!",HttpStatus.NOT_FOUND);
	}
    
}
