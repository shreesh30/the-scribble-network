package com.scribblenetwork.service;

import com.scribblenetwork.entity.UserEntity;
import com.scribblenetwork.model.UserModel;

public interface UserService {
    UserModel register(UserModel user);

    String verifyUser(UserModel user);

    UserEntity getUser(String userName);
}
