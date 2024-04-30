package com.hirehub.company.microservice.company;

import java.util.List;

import com.hirehub.company.microservice.company.dto.ReviewMessage;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompanyById(Long id, Company updatedCompany);
    Company createCompany(Company company,Long user);
    boolean deleteCompanyById(Long id);
    Company findCompanyById(Long id);
    List<Company> searchCompany(String keyword);
    Company getCompanyByUserId(Long Userid);
    Boolean updateHiringStatus(Long id);
    void updateCompanyRating(ReviewMessage reviewMessage);
}
