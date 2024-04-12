package com.hirehub.EmployEase.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hirehub.EmployEase.alluser.USER_ROLE;
import com.hirehub.EmployEase.alluser.User;
import com.hirehub.EmployEase.alluser.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmailId(username);
        if(userOptional.isEmpty())
        {
            throw new UsernameNotFoundException("User not found with email "+username);
        }
        User user = userOptional.get();
        USER_ROLE role=user.getRole();
        if(role==null) role=USER_ROLE.ROLE_EMPLOYEE;
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.toString()));

        return new org.springframework.security.core.userdetails.User(user.getEmailId(),user.getPassword(),authorities);
    }
}
