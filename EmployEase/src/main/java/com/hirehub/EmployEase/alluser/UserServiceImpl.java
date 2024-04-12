package com.hirehub.EmployEase.alluser;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hirehub.EmployEase.config.JwtProvider;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private JwtProvider jwtProvider;

    public UserServiceImpl(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public User findUserByJwtToken(String jwt) {
        String emailId = jwtProvider.getEmailIdFromJwtToken(jwt);
        Optional<User> user = userRepository.findByEmailId(emailId);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public User findUserByEmailId(String emailId){
        Optional<User> user = userRepository.findByEmailId(emailId);
        return user.isPresent() ? user.get() : null;
    }

}
