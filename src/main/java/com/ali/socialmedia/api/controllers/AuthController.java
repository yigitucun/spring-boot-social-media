package com.ali.socialmedia.api.controllers;

import com.ali.socialmedia.business.abstracts.AuthService;
import com.ali.socialmedia.core.dto.requests.AddUserRequest;
import com.ali.socialmedia.core.dto.requests.AuthenticateRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddUserRequest request){
        return new ResponseEntity<>(this.authService.add(request), HttpStatus.CREATED);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest request){
        return ResponseEntity.ok(this.authService.authenticate(request));
    }
}
