package com.scribblenetwork.service;

import com.scribblenetwork.entity.UserEntity;
import com.scribblenetwork.model.UserModel;
import com.scribblenetwork.repository.UserRepository;
import com.scribblenetwork.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(getClass());

    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    private JWTService jwtService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public UserModel register(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UserUtils.generateUserId());
        userEntity.setUsername(userModel.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userEntity = userRepository.save(userEntity);
        userModel = UserUtils.getUserModel(userEntity);
        return userModel;
    }

    @Override
    public UserEntity getUser(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public String verifyUser(UserModel user) {
        String jwtToken = null;
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            UserEntity userEntity = getUser(user.getUsername());
            jwtToken = jwtService.generateToken(user.getUsername(), userEntity.getId());
        }
        return jwtToken;
    }


}
