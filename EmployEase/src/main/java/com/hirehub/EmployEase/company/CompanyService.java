package com.hirehub.EmployEase.company;

import java.util.List;

import com.hirehub.EmployEase.alluser.User;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompanyById(Long id, Company updatedCompany);
    void createCompany(Company company,User user);
    boolean deleteCompanyById(Long id);
    Company findCompanyById(Long id);
    List<Company> searchCompany(String keyword);
    Company getCompanyByUserId(Long Userid);
    Boolean updateHiringStatus(Long id);
}
