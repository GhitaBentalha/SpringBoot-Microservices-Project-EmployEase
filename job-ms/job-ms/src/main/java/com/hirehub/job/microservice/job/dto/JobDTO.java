package com.hirehub.job.microservice.job.dto;
import java.util.List;

import com.hirehub.job.microservice.job.external.Company;
import com.hirehub.job.microservice.job.external.Review;

public class JobDTO {
    
    private Long id;
    private String title;
	private String description;
	private String minSalary;
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private String maxSalary;
	private String location;
    private Integer experience;
    private Company company;
    private List<Review> reviews;
    private Double averageRating; 
    
    public Double getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
   
	public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
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
    
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

}
