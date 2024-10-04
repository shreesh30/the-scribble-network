package com.scribblenetwork.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String generateToken(String userUsername, String userId);

    String extractUsername(String token);

    boolean validateToken(String token, UserDetails userDetails);
}
