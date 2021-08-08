package com.task.list.api.security;

import org.springframework.security.core.userdetails.UserDetails;


public interface IJwtService {
    String createToken(UserDetails userDetails);
    Boolean hasTokenExpired(String token);
    Boolean validateToken(String token, UserDetails userDetails);
    String extractUsername(String token);
}
