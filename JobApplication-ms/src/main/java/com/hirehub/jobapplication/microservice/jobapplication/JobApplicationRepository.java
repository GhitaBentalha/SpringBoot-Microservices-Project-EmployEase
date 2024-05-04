package com.hirehub.jobapplication.microservice.jobapplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication,Long>{

    List<JobApplication> findByJobId(Long jobId);

    List<JobApplication> findByUserId(Long userId);

}
