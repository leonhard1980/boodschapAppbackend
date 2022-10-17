package com.example.demo.controller;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Role;
import com.example.demo.model.AppUser;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepos;
    private final RoleRepository roleRepos;
    private final PasswordEncoder encoder;

    public UserController(UserService userService, UserRepository userRepos, RoleRepository roleRepos, PasswordEncoder encoder) {
        this.userRepos = userRepos;
        this.roleRepos = roleRepos;
        this.userService = userService;
        this.encoder = encoder;
    }

    @GetMapping("/users")
    public Iterable<AppUser> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public String createUser(@RequestBody UserDto userDto) {
        AppUser newAppUser = new AppUser();
        newAppUser.setUsername(userDto.username);
        newAppUser.setPassword(encoder.encode(userDto.password));

        List<Role> userRoles = new ArrayList<>();
        for (Long roleId : userDto.roleIds) {
            Optional<Role> or = roleRepos.findById(roleId);

            userRoles.add(or.get());
        }
        newAppUser.setRoles(userRoles);

        userRepos.save(newAppUser);

        return "Done";
    }
}