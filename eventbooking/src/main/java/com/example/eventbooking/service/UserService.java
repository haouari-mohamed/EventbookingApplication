package com.example.eventbooking.service;

import com.example.eventbooking.model.User;
import com.example.eventbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        String password = user.getPassword();
        if (password != null) {
            String hashedPassword = passwordEncoder.encode(password);
            user.setPassword(hashedPassword);
        }
        return userRepository.save(user);
    }


    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User updateUtilisateur(long id, User utilisateurDetails) {
        User user = getUserById(id);
        user.setUsername(utilisateurDetails.getUsername());
        user.setEmail(utilisateurDetails.getEmail());
        user.setPassword(utilisateurDetails.getPassword());
        return userRepository.save(user);
    }

    public void deleteUtilisateur(int id) {
        User utilisateur = getUserById(id);
        userRepository.delete(utilisateur);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
