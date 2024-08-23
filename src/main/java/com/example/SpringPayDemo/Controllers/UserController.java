package com.example.SpringPayDemo.Controllers;

import com.example.SpringPayDemo.Models.User;
import com.example.SpringPayDemo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService _userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String userLogin(@RequestParam String phoneNumber, @RequestParam String userPassword, Model model) {
        User existingUser = _userService.findUserByPhoneNumber(phoneNumber);
        try {
            if(existingUser != null && existingUser.get_password().equals(userPassword)) {
                return "/redirect/pay";
            } else {
                model.addAttribute("error", "Invalid Credentials");
                return "login";
            }
        }
        catch(Exception ex) {
            System.out.println("Exception Desc: " + ex.getMessage());
        }
        return null;
    }

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String phoneNumber, @RequestParam String name, @RequestParam String password) {
        User newUser = new User(phoneNumber, name, password);
        _userService.registerUser(newUser);
        return "redirect:/login";
    }
}
