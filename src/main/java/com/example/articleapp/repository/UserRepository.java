//Extends JpaRepository<User, Long> to handle User CRUD operations.
package com.example.articleapp.repository;

import com.example.articleapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

}

