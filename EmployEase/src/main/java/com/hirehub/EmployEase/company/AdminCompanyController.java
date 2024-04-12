package com.hirehub.EmployEase.company;

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
import org.springframework.web.bind.annotation.RestController;

import com.hirehub.EmployEase.alluser.User;
import com.hirehub.EmployEase.alluser.UserService;

@RestController
@RequestMapping("/api/admin/companies")
public class AdminCompanyController {

    private CompanyService companyService;
    private UserService userService;

    public AdminCompanyController(CompanyService companyService, UserService userService) {
        this.companyService = companyService;
        this.userService = userService;
    }
    
    @PostMapping()
	public ResponseEntity<Company> createCompany(@RequestBody Company company,
    @RequestHeader("Authorization") String jwt) throws Exception
	{
        User user = userService.findUserByJwtToken(jwt);
		companyService.createCompany(company,user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@PathVariable Long id,
     @RequestHeader("Authorization") String jwt, @RequestBody Company updatedCompany)
	{
		boolean updated = companyService.updateCompanyById(id,updatedCompany);
		if(updated)
		return new ResponseEntity<>("Company updated successfully",HttpStatus.OK);
		return new ResponseEntity<>("Company not found!",HttpStatus.NOT_FOUND);
	}
    
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompanyById(@PathVariable Long id,
    @RequestHeader("Authorization") String jwt)
	{
		boolean deleted = companyService.deleteCompanyById(id);
		if(deleted)
		return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
		return new ResponseEntity<>("Company not found!",HttpStatus.NOT_FOUND);
	}

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateHiringStatus(@PathVariable Long id,
    @RequestHeader("Authorization") String jwt)
    {
        if(companyService.updateHiringStatus(id))
        {
            return new ResponseEntity<>("Hiring status updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not found!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user")
    public ResponseEntity<Company> getCompanyByUserId(@RequestHeader("Authorization") String jwt)
	{
       User user = userService.findUserByJwtToken(jwt);
       if(user!=null)
       {
       Company company = companyService.getCompanyByUserId(user.getId());
	   return new ResponseEntity<>(company,HttpStatus.OK);
       }
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
