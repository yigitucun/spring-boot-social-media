package com.ali.socialmedia.core.dto.requests;

import com.ali.socialmedia.core.annonations.auth.abstracts.UniqueEmail;
import com.ali.socialmedia.core.annonations.auth.abstracts.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class AddUserRequest {
    @NotBlank(message = "Name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @Email(message = "Invalid email address")
    @UniqueEmail
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Username is required")
    @UniqueUsername
    private String username;
    @NotBlank(message = "Password id required")
    @Length(min = 6,max = 60,message = "Password must be 6 characters")
    private String password;

    public AddUserRequest(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public AddUserRequest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }
}
