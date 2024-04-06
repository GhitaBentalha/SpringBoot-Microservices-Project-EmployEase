package com.hirehub.EmployEase.company;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    
    @Override
    public List<Company> getAllCompanies() {
       return companyRepository.findAll();
    }

    @Override
    public boolean updateCompanyById(Long id, Company updatedCompany) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        {
            if(companyOptional.isPresent())
            {
                Company company = companyOptional.get();
                company.setName(updatedCompany.getName());
                company.setDescription(updatedCompany.getDescription());
                company.setJobs(updatedCompany.getJobs());
                companyRepository.save(company);
                return true;
            }  
        }
       return false;
    }

    @Override
    public void createCompany(Company company) {
       companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id))
        {
           companyRepository.deleteById(id);
           return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

}
