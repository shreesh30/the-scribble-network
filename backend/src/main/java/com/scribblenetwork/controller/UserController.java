package com.scribblenetwork.controller;

import com.scribblenetwork.exception.ScribbleException;
import com.scribblenetwork.model.UserModel;
import com.scribblenetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<UserModel> register(@RequestBody UserModel user) throws ScribbleException {
        try {
            return new ResponseEntity<>(userService.register(user), HttpStatus.OK);
        }catch (Exception e){
            throw new ScribbleException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping(path = "/login")
    public String login(@RequestBody UserModel user) throws ScribbleException {
        try {
            return userService.verifyUser(user);
        }
        catch(Exception e){
            throw new ScribbleException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    @GetMapping(path = "/")
    public String test(){
        return "Success";
    }
}
