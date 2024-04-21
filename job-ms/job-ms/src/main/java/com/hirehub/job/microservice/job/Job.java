package com.hirehub.job.microservice.job;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	private String title;
	private String description;
	private String minSalary;
	private String maxSalary;
	private String location;
	private Integer experience;
	private Long companyId;

	@Enumerated(EnumType.STRING)
	private JOB_TYPE jobType;

	public Job(long id, String title, String description, String minSalary, String maxSalary, String location,
            Integer experience, JOB_TYPE jobType,Long companyId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
        this.experience = experience;
        this.jobType = jobType;
        this.companyId = companyId;
    }

	public Job()
	{

	}
	
	public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public JOB_TYPE getJobType() {
        return jobType;
    }

    public void setJobType(JOB_TYPE jobType) {
        this.jobType = jobType;
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
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

    public boolean isFullTime() {
        return jobType == JOB_TYPE.FULL_TIME;
    }

    public boolean isInternship() {
        return jobType == JOB_TYPE.INTERNSHIP;
    }
	
}
