package com.scribblenetwork.utils;

import com.scribblenetwork.entity.UserEntity;
import com.scribblenetwork.model.UserModel;
import com.scribblenetwork.model.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

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

    public static String getLoggedInUserId(){
        UserPrincipal userPrincipal=(UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userPrincipal.getUserId();
    }

    public static UserEntity getLoggedInUser(){
        UserPrincipal userPrincipal=(UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userPrincipal.getUser();
    }
}
