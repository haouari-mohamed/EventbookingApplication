package com.example.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.eventbooking.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findUserByUsername(String username);
}
