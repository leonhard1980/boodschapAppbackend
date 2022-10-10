package com.example.demo.services;

import com.example.demo.model.AppUser;
import com.example.demo.repositories.UserRepository;

import java.util.Collection;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userNameIsValid(String userName) {
        return userRepository.findByUserName(userName).isEmpty();
    }
    public boolean userNameHasToManyWrongLogins(String userName) {
        Optional<AppUser> user = userRepository.findByUserName(userName);
        if (user.isEmpty())
            return false;
        return user.get().hasTooManyWrongLogins;
    }
}
