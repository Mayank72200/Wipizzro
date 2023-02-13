package com.Wipro.User.Controller;

import com.Wipro.User.Entity.User;
import com.Wipro.User.Repository.UserRepository;
import com.Wipro.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.security.Principal;

// This controller containes all those endpoints which will be particularly fired by a customer only
@RestController
@RequestMapping("/user")
public class CustController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    //If any Customer wants to check his profile then this endpoint will work it will get all the
    //customer information.
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId ){

        User user =userService.getUser(userId);
        return ResponseEntity.ok(user);

    }

    //This endpoint will work when any customer wants to delete his account from the backend.
    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable String userId){

        userService.deleteUser(userId);

        return "Deleted";

    }

    // This endpoint will update the current existing customer, customer can itself update its information
    // that is present in backend.
    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable String userId){
        userService.updateUser(user,userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getOrders/{userId}")
    public ResponseEntity<User> getUserOrders(@PathVariable String userId){

        User user =userService.getUserOrders(userId);

        return ResponseEntity.ok(user);


    }


}
