package com.scribblenetwork.controller;

import com.scribblenetwork.model.UserModel;
import com.scribblenetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public UserModel register(@RequestBody UserModel user) {
        return userService.register(user);
    }

    @PostMapping(path = "/login")
    public String login(@RequestBody UserModel user) {
        return userService.verifyUser(user);
    }
}
