package com.digitaldiaries.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(path = "/")
    public String createUser(){
        return "User Created";
    }
}
