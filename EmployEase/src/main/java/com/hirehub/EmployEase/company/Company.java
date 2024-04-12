package com.hirehub.EmployEase.company;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hirehub.EmployEase.alluser.User;
import com.hirehub.EmployEase.job.Job;
import com.hirehub.EmployEase.review.Review;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    private User owner;
    
    @Column(length =1000)
    private String companyLogo;
    private boolean hiring;

    @OneToMany(mappedBy = "company",cascade=CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<Job> jobs;
    
    @OneToMany(mappedBy="company",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<Review> reviews;

    public Company()
    {   
    }
    
    public Company(Long id, String name, String description, User owner, String companyLogo, boolean hiring,
            List<Job> jobs, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.companyLogo = companyLogo;
        this.hiring = hiring;
        this.jobs = jobs;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public boolean isHiring() {
        return hiring;
    }

    public void setHiring(boolean hiring) {
        this.hiring = hiring;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    
}
