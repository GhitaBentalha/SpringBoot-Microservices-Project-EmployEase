package com.hirehub.user.microservice.alluser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

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
}
