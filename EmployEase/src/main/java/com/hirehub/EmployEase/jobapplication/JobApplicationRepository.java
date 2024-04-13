package com.hirehub.EmployEase.jobapplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication,String>{

    List<JobApplication> findByJobId(Long jobId);

    List<JobApplication> findByUserEmailId(String emailId);

}
