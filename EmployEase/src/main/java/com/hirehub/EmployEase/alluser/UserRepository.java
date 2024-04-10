package com.hirehub.EmployEase.alluser;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String username);
}
