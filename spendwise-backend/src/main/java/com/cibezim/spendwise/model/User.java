package com.cibezim.spendwise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Represents a user entity in the SpendWise application.
 */
@Entity
@Table(name = "users")
public class User {

    /** The unique identifier for the user. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The username of the user. Must not be blank and should be unique. */
    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String username;

    /** The password of the user. Must not be blank. */
    @NotBlank
    @Size(max = 100)
    private String password;

    /** The email address of the user. Must be a valid email format and should be unique. */
    @NotBlank
    @Size(max = 100)
    @Email
    @Column(unique = true)
    private String email;

    /**
     * Default constructor.
     */
    public User() {

    }

    /**
     * Constructs a new user with the specified username, password, and email.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param email    the email address of the user
     */
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Retrieves the unique identifier of the user.
     *
     * @return the user's identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param id the new identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the username of the user.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the new username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the new password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email the new email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of the user.
     *
     * @return a string representation including the user's id, username, password, and email
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
