package com.hirehub.EmployEase.company;

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
public class CompanyController {

    private CompanyService companyService;
    
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
	public ResponseEntity<List<Company>> findAll()
	{
		return ResponseEntity.ok((companyService.getAllCompanies()));
	}

	@GetMapping("/hello")
	public String helloWorld()
	{
		return "hello!";
	}
	
	@GetMapping("/companies/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id)
	{
       Company company = companyService.findById(id);
	   if(company!=null)
	   return new ResponseEntity<>(company,HttpStatus.OK);
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @PostMapping("/companies")
	public ResponseEntity<Company> createJob(@RequestBody Company company)
	{
		companyService.createCompany(company);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
    
    @PutMapping("companies/{id}")
    public ResponseEntity<String> updateCompanyById(@PathVariable Long id,
	@RequestBody Company updatedCompany)
	{
		boolean updated = companyService.updateCompanyById(id,updatedCompany);
		if(updated)
		return new ResponseEntity<>("Company updated successfully",HttpStatus.OK);
		return new ResponseEntity<>("Company not found!",HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/companies/{id}")
	public ResponseEntity<String> deleteCompanyById(@PathVariable Long id)
	{
		boolean deleted = companyService.deleteCompanyById(id);
		if(deleted)
		return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
		return new ResponseEntity<>("Company not found!",HttpStatus.NOT_FOUND);
	}
}
