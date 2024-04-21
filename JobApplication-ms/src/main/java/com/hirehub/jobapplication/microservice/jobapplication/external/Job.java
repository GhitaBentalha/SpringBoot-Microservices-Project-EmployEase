package com.hirehub.jobapplication.microservice.jobapplication.external;

public class Job {
	private long id;
	private String title;
	private String description;
	private String minSalary;
	private String maxSalary;
	private String location;
	private Integer experience;
	private JOB_TYPE jobType;
	
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
	
}
