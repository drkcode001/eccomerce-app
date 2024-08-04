package com.myecommerce.eccomerceapp.controller;

import com.myecommerce.eccomerceapp.model.User;
import com.myecommerce.eccomerceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.authenticateUser(user.getUsername(), user.getPassword()));
    }
}

// Why use @RequestBody?
// It automatically deserializes the JSON in the request body into a User object.

// Why return ResponseEntity?
// It gives us more control over the HTTP response, including status codes and headers.