package com.example.eventbooking.controller;

import com.example.eventbooking.config.JwtAuth;
import com.example.eventbooking.model.User;
import com.example.eventbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtAuth jwtAuth;

    @PostMapping("/signup")
    public User saveUtilisateur(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getUtilisateur/{id}")
    public User getUtilisateur(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/showAllUtilisateur")
    public List<User> getAllUtilisateurs() {
        return userService.getAllUser();
    }

    @PutMapping("/edit/{id}")
    public User updateUtilisateur(@PathVariable int id, @RequestBody User utilisateurDetails) {
        return userService.updateUtilisateur(id, utilisateurDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUtilisateur(@PathVariable int id) {
        userService.deleteUtilisateur(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && new BCryptPasswordEncoder().matches(user.getPassword(), foundUser.getPassword())) {
            List<String> roles = Collections.singletonList(foundUser.getRole().name());
            String token = jwtAuth.generateToken(foundUser.getUsername(), roles);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }
}
