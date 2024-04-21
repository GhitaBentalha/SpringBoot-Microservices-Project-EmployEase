package com.hirehub.job.microservice.job.dto;
import java.util.List;

import com.hirehub.job.microservice.job.JOB_STATUS;
import com.hirehub.job.microservice.job.JOB_TYPE;
import com.hirehub.job.microservice.job.WORK_MODE;
import com.hirehub.job.microservice.job.external.Company;
import com.hirehub.job.microservice.job.external.Review;

public class JobDTO {
    
    private Long id;
    private String title;
	private String description;
	private String minSalary;
    private String maxSalary;
	private String location;
    private Integer experience;
    private List<String> keySkills;
	private WORK_MODE workMode;
	private JOB_STATUS status;
    private JOB_TYPE jobType;
    private Company company;
    private List<Review> reviews;
    private Double averageRating;

	public Double getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
    public Company getCompany() {
        return company;
    }
    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getMinSalary() {
        return minSalary;
    }
    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }
    public String getMaxSalary() {
        return maxSalary;
    }
    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Integer getExperience() {
        return experience;
    }
    public void setExperience(Integer experience) {
        this.experience = experience;
    }
    public List<String> getKeySkills() {
        return keySkills;
    }
    public void setKeySkills(List<String> keySkills) {
        this.keySkills = keySkills;
    }
    public WORK_MODE getWorkMode() {
        return workMode;
    }
    public void setWorkMode(WORK_MODE workMode) {
        this.workMode = workMode;
    }
    public JOB_STATUS getStatus() {
        return status;
    }
    public void setStatus(JOB_STATUS status) {
        this.status = status;
    }
    public JOB_TYPE getJobType() {
        return jobType;
    }
    public void setJobType(JOB_TYPE jobType) {
        this.jobType = jobType;
    }

   
}
