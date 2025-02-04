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
    public User findByUserId(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    public User findByEmailId(String emailId) {
        // Implémentation pour rechercher l'utilisateur par email
        // Cela pourrait impliquer un appel à un repository JPA
        return userRepository.findByEmailId(emailId);
    }


}
