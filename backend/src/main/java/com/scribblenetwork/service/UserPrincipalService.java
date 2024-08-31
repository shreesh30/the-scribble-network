package com.scribblenetwork.service;

import com.scribblenetwork.entity.UserEntity;
import com.scribblenetwork.model.UserPrincipal;
import com.scribblenetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserPrincipalService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user=userRepository.findByUsername(username);
        if(user==null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found");
        }


        return new UserPrincipal(user);
    }
}
