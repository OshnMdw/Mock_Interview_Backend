package com.oshnmdw.mock_interview.controller;

import com.oshnmdw.mock_interview.model.User;
import com.oshnmdw.mock_interview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        System.out.println(user);
        String token = userService.login(user);
        return ResponseEntity.ok(token);
    }
}
