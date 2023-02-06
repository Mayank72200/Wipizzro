package com.Wipro.User.Service.Impl;


import com.Wipro.User.Entity.User;
import com.Wipro.User.Exceptions.ResourceNotFound;
import com.Wipro.User.Repository.UserRepository;
import com.Wipro.User.Service.UserService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServicesImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

    private Logger log = LoggerFactory.getLogger(UserServicesImpl.class);

    @Override
    public User saveUser(User user) {
        //generate Unique userID
        String randomUserId =UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("Customer with given details not found on server !"));

    }

    @Override
    public User deleteUser(String userId) {
        User user = userRepo.findById(userId).get();
        userRepo.deleteById(userId);
        return user;
    }

    @Override
    public User updateUser(User user, String userId) {
        userRepo.save(user);
        User userup=userRepo.getById(userId);
        return userup;
    }

    @Override
    public User getUserOrders(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("Customer with given details not found on server !"));
        //http://localhost:8083/order/345ce7f6-bd58-4a2b-abe4-ccd350e76c64
        ArrayList ordersOfUser=restTemplate.getForObject("http://localhost:8083/order/"+user.getUserId(), ArrayList.class);
        log.info("{} ",ordersOfUser);
        user.setOrders(ordersOfUser);
        return user;
    }
}
