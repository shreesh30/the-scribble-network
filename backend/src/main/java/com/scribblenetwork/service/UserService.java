package com.scribblenetwork.service;

import com.scribblenetwork.model.UserModel;

public interface UserService {
    UserModel register(UserModel user);

    String verifyUser(UserModel user);
}
