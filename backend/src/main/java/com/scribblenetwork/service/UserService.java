package com.scribblenetwork.service;

import com.scribblenetwork.entity.UserEntity;
import com.scribblenetwork.exception.ScribbleException;
import com.scribblenetwork.exception.UnauthorizedException;
import com.scribblenetwork.model.UserModel;

public interface UserService {
    UserModel register(UserModel user) throws ScribbleException;

    String verifyUser(UserModel user) throws UnauthorizedException;

    UserEntity getUser(String userName);
}
