package com.example.SpringPayDemo.Services;

import com.example.SpringPayDemo.Models.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> userDetails = new HashMap<>();

    public User findUserByPhoneNumber(String phoneNumber) {
        return userDetails.get(phoneNumber);
    }

    public void registerUser(User user) {
        userDetails.put(user.get_phoneNumber(), user);
    }
}
