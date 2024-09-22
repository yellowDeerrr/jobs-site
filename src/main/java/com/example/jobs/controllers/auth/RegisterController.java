package com.example.jobs.controllers.auth;

import com.example.jobs.payload.requests.auth.RegisterRequest;
import com.example.jobs.services.auth.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        return registerService.registerUser(registerRequest) ? ResponseEntity.ok().body(registerRequest) : ResponseEntity.badRequest().body("Login is already using");
    }
}
