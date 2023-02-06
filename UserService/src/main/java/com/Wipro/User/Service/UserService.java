package com.Wipro.User.Service;

import com.Wipro.User.Entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User customer);

    List<User> getAllUser();

    User getUser(String userId);

    User deleteUser(String userId);

    User updateUser(User user, String userId);

    User getUserOrders(String userId);
}