package com.hirehub.EmployEase.company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private CompanyService companyService;
    
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

	@GetMapping("/search")
	public 	ResponseEntity<List<Company>> searchCompany(@RequestHeader("Authorization") String jwt,
	@RequestParam String keyword)
	{
		return ResponseEntity.ok((companyService.searchCompany(keyword)));
	}

    @GetMapping()
	public ResponseEntity<List<Company>> findAll(@RequestHeader("Authorization") String jwt)
	{
		return ResponseEntity.ok((companyService.getAllCompanies()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@RequestHeader("Authorization") String jwt,@PathVariable Long id)
	{
       Company company = companyService.findCompanyById(id);
	   if(company!=null)
	   return new ResponseEntity<>(company,HttpStatus.OK);
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
