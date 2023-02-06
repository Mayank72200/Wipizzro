package com.Wipro.User.Controller;

import com.Wipro.User.Entity.User;
import com.Wipro.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //If any user want to register himself then this endpoint will be fired this is basiclly a registration form.
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){

        User cust= userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(cust);
    }
}
