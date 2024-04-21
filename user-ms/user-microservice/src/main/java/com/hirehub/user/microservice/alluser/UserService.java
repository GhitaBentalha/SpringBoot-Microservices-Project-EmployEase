package com.hirehub.user.microservice.alluser;

public interface UserService {
    public User findByUserId(Long id) throws Exception;
    public void createUser(User user);

}
