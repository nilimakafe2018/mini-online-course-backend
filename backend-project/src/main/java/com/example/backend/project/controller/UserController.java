package com.example.backend.project.controller;
import com.example.backend.project.model.User;
import com.example.backend.project.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping ("/api/users") //base path for my endpoints
@CrossOrigin

public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //check if the email already exists, if not create a new user
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return userRepository.findByEmail(user.getEmail())
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok(userRepository.save(user)));
    }

    //reading all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //reading one user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    //updating user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setInstitution(updatedUser.getInstitution());
        return userRepository.save(user);
    }

    //deleting user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}