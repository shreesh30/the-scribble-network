package com.digitaldiaries.service;

import com.digitaldiaries.entity.Users;
import com.digitaldiaries.model.UserPrincipal;
import com.digitaldiaries.repository.UserRepository;
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

        Users user=userRepository.findByUsername(username);
        if(user==null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found");
        }


        return new UserPrincipal(user);
    }
}
