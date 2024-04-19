package com.hirehub.company.microservice.company;

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
                if(updatedCompany.getName()!=null)
                {
                    company.setName(updatedCompany.getName());
                }
                if(updatedCompany.getDescription()!=null)
                {
                    company.setDescription(updatedCompany.getDescription());
                }
                if(updatedCompany.getCompanyLogo()!=null)
                {
                    company.setCompanyLogo(updatedCompany.getCompanyLogo());
                }
                if(updatedCompany.getOwnerId()!=null)
                {
                    company.setOwnerId(updatedCompany.getOwnerId());
                }
                companyRepository.save(company);
                return true;
            }  
        }
       return false;
    }

    @Override
    public void createCompany(Company company,Long userId) {
       company.setOwnerId(userId);
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
    public Company findCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Company> searchCompany(String keyword) {
       return companyRepository.findBySearchQuery(keyword);
    }

    @Override
    public Company getCompanyByUserId(Long Userid) {
        Company company = companyRepository.findByOwnerId(Userid);
        return company;
    }

    @Override
    public Boolean updateHiringStatus(Long id) {
        Company company = companyRepository.findById(id).orElse(null);
        if(company!=null)
        {
            company.setHiring(!company.isHiring());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

}
