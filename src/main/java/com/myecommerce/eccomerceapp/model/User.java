// File: src/main/java/com/myecommerce/eccomerceapp/model/User.java

package com.myecommerce.eccomerceapp.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;  // This will store the hashed password

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}

// Why not use @Table(name = "users")?
// In H2, "USER" is not a reserved keyword, so we can use it as our table name.
// H2 will automatically create a table named "USER" (in uppercase) for this entity.

// Why use @Column annotations?
// They allow us to specify constraints directly in our entity, ensuring data integrity at the database level.

// Why include a createdAt field with @PrePersist?
// This automatically timestamps when a user is created, which can be useful for auditing and data analysis.