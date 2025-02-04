package com.hirehub.user.microservice.alluser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/profile/{id}")
    public ResponseEntity<User> findUserId(@PathVariable Long id) throws Exception
    {
        User user = userService.findByUserId(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> createUser(@RequestBody User user)
    {
        userService.createUser(user);
        return new ResponseEntity<>("User created successfully!",HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Ici, vous pouvez ajouter une logique de validation supplémentaire si nécessaire
        return ResponseEntity.ok("Connexion réussie !");
    }

}
