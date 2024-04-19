package com.hirehub.user.microservice.alluser;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByEmailId(String emailId){
        Optional<User> user = userRepository.findByEmailId(emailId);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

}
