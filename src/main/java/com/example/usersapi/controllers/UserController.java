package com.example.usersapi.controllers;

import com.example.usersapi.models.User;
import com.example.usersapi.services.UserService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    @GetMapping()
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public User getOneUser(@PathVariable String id) {
        return service.findOne(id);
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping()
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable String id) {
        service.deleteUser(id);
    }
}
