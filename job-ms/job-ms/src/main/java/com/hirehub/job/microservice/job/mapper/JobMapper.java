package com.hirehub.job.microservice.job.mapper;

import java.util.List;
import com.hirehub.job.microservice.job.Job;
import com.hirehub.job.microservice.job.dto.JobDTO;
import com.hirehub.job.microservice.job.external.Company;
import com.hirehub.job.microservice.job.external.Review;

public class JobMapper {

    public static JobDTO mapToJobWithCompanyDTO(Job job, Company company,List<Review> reviews, Double averageRating)
    {
        JobDTO jobWithCompanyDTO = new JobDTO();
        jobWithCompanyDTO.setId(job.getId());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setExperience(job.getExperience());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setCompany(company);
        jobWithCompanyDTO.setReviews(reviews);
        jobWithCompanyDTO.setAverageRating(averageRating);
        return jobWithCompanyDTO;
    }

}
