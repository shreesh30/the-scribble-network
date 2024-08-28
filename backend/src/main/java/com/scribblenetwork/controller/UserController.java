package com.scribblenetwork.controller;

import com.scribblenetwork.entity.Users;
import com.scribblenetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public Users register(@RequestBody Users user) {
        return userService.register(user);
    }

    @PostMapping(path = "/login")
    public String login(@RequestBody Users user) {
        return userService.verifyUser(user);
    }

    @GetMapping(path = "/")
    public List<Users> getUsers() {
        return userService.getUsers();
    }
}
