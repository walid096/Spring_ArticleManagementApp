//The JPA entity representing a user.
package com.example.articleapp.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // auto-generated user ID
    private String username; // user's username
    private String password; // hashed password
    private String email; // email
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

