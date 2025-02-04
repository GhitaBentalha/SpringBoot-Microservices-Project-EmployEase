package com.hirehub.user.microservice.alluser;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmailId(String username);
}
