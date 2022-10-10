package com.example.demo.security;

import com.example.demo.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class MyAuthenticationManager implements AuthenticationManager {

    private final UserService userService;

    public MyAuthenticationManager(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        userService.checkUser(authentication.getPrincipal(), authentication.getCredentials())
        return null;
    }
}
