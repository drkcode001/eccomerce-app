package com.myecommerce.eccomerceapp.repository;

import com.myecommerce.eccomerceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}

// Why use Optional<User> for findBy methods?
// It clearly indicates that the result may or may not be present, encouraging proper null handling.

// Why include existsBy methods?
// These are more efficient for checking existence as they don't need to fetch the entire entity.