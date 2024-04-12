package com.hirehub.EmployEase.alluser;

public interface UserService {

    public User findUserByJwtToken(String jwt);

    public User findUserByEmailId(String emailId) throws Exception;

}
