package com.hirehub.EmployEase.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompanyById(Long id, Company updatedCompany);
    void createCompany(Company company);
    boolean deleteCompanyById(Long id);
    Company findById(Long id);
}
