package com.example.eventbooking.repository;

import com.example.eventbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findUserByUsername(String username);
}