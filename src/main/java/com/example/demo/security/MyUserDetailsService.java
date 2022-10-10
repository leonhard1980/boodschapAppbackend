package com.example.demo.security;


import com.example.demo.model.AppUser;
import com.example.demo.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepos;

    public MyUserDetailsService(UserRepository repos) {
        this.userRepos = repos;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> ou = userRepos.findByUserName(username);
        if (ou.isPresent()) {
            AppUser appUser = ou.get();
            return new MyUserDetails(appUser);
        }
        else {
            throw new UsernameNotFoundException(username);
        }
    }
}
