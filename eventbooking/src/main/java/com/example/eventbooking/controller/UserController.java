package com.example.eventbooking.controller;

import com.example.eventbooking.config.JwtAuth;
import com.example.eventbooking.model.User;
import com.example.eventbooking.model.UserRole;
import com.example.eventbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

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
    public ResponseEntity<?> login(@RequestBody User user) {
        User user2 = userService.findByUsername(user.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        UserRole role = user2.getRole();
        String token = jwtAuth.generateToken(user.getUsername(), role);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
