package com.myecommerce.eccomerceapp.service;

import com.myecommerce.eccomerceapp.model.User;
import com.myecommerce.eccomerceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        // Check if username or email already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public User authenticateUser(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }
}

// Why use constructor injection instead of field injection?
// It makes the dependencies explicit and allows for easier testing.

// Why throw RuntimeException for existing username/email?
// In a real-world app, you'd create custom exceptions for these cases. This is a simplification.

// Why use passwordEncoder.matches() instead of String.equals()?
// It safely compares the raw password with the hashed password stored in the database.