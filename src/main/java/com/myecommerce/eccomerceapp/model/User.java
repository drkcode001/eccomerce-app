package com.myecommerce.eccomerceapp.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password; // Note: In a real app, we'd hash this password

    // Why separate username and email? It allows for more flexible user identification options.
}
