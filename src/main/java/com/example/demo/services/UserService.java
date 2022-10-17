package com.example.demo.services;

import com.example.demo.model.AppUser;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userNameIsValid(String userName) {
        return userRepository.findByUsername(userName).isEmpty();
    }
    public boolean userNameHasToManyWrongLogins(String userName) {
        Optional<AppUser> user = userRepository.findByUsername(userName);
        if (user.isEmpty())
            return false;
        return user.get().hasTooManyWrongLogins;
    }

    public Iterable<AppUser> getAllUsers(){
        return userRepository.findAll();
    }
}
