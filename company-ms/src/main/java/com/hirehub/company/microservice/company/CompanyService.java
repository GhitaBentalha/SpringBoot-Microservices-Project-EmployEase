package com.hirehub.company.microservice.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompanyById(Long id, Company updatedCompany);
    Company createCompany(Company company,Long user);
    boolean deleteCompanyById(Long id);
    Company findCompanyById(Long id);
    List<Company> searchCompany(String keyword);
    Company getCompanyByUserId(Long Userid);
    Boolean updateHiringStatus(Long id);
}
