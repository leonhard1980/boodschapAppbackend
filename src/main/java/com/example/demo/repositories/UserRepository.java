package com.example.demo.repositories;

import com.example.demo.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String userName);
}
