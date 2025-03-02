package com.inu.hackerton.spring.controller;

import com.inu.hackerton.spring.model.User;
import com.inu.hackerton.spring.model.UserResponse;
import com.inu.hackerton.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody User user) {
        User savedUser = userService.create(user);
        return new UserResponse(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        Optional<User> user = userService.read(id);
        return user.map(u -> new UserResponse(u.getId(), u.getUsername(), u.getEmail()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.update(id, user);
        return new UserResponse(updatedUser.getId(), updatedUser.getUsername(), updatedUser.getEmail());
    }
}
