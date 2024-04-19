package com.hirehub.user.microservice.alluser;

public interface UserService {
    public User findUserByEmailId(String emailId) throws Exception;
    public void createUser(User user);

}
