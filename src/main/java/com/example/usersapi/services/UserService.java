package com.example.usersapi.services;

import com.example.usersapi.models.User;
import com.example.usersapi.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UsersRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findOne(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found."));
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(User user) {
        Optional<User> existingUser = repository.findById(user.getId());
        if (existingUser.isPresent()) {
            return repository.save(user);
        } else {
            throw new RuntimeException("User with id " + user.getId() + " not found.");
        }
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }


}
