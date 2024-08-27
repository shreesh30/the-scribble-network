package com.scribblenetwork.service;

import com.scribblenetwork.entity.Users;

import java.util.List;

public interface UserService {

    public Users register(Users user);

    public List<Users> getUsers();

    String verifyUser(Users user);
}
