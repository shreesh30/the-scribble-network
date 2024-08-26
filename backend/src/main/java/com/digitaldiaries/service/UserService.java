package com.digitaldiaries.service;

import com.digitaldiaries.entity.Users;

import java.util.List;

public interface UserService {

    public Users register(Users user);

    public List<Users> getUsers();
}
