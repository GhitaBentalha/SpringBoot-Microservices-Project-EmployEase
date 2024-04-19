package com.hirehub.user.microservice.alluser;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String emailId;
    private String password;

    public User()
    {

    }
    
    public User(Long id, String fullName, String emailId, String password, USER_ROLE role, String resume,
            String profilePhoto, List<String> skills) {
        this.id = id;
        this.fullName = fullName;
        this.emailId = emailId;
        this.password = password;
        this.role = role;
        this.resume = resume;
        this.profilePhoto = profilePhoto;
        this.skills = skills;
    }

    @Enumerated(EnumType.STRING)
    private USER_ROLE role;

    private String resume;
    private String profilePhoto;

    private List<String> skills;

    public Long getOwnedCompany() {
        return ownedCompany;
    }

    public void setOwnedCompany(Long ownedCompany) {
        this.ownedCompany = ownedCompany;
    }
    private Long ownedCompany;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

}
