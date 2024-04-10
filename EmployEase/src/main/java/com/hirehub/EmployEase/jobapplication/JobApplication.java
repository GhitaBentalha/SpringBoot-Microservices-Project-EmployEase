package com.hirehub.EmployEase.jobapplication;

import java.time.LocalDateTime;

import com.hirehub.EmployEase.alluser.User;
import com.hirehub.EmployEase.job.Job;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
@Entity
@AllArgsConstructor
public class JobApplication {
    @Id
    public String jobApplicationId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Job job;
    private JOB_APPLICATION_STATUS status;

    private LocalDateTime appliedDate;

    public JobApplication() {
        this.jobApplicationId = ApplicationIdGenerator.generateId(10);
    }

}
