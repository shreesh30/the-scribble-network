package com.scribblenetwork.utils;

import com.scribblenetwork.entity.UserEntity;
import com.scribblenetwork.model.UserModel;

import java.util.UUID;

public class UserUtils {

    public static String generateUserId() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public static UserModel getUserModel(UserEntity user){
        UserModel userModel=new UserModel();
        userModel.setId(user.getId());
        userModel.setUsername(user.getUsername());
        return userModel;
    }
}
