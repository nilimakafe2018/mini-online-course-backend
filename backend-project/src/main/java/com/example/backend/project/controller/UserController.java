package com.example.backend.project.controller;
import com.example.backend.project.model.User;
import com.example.backend.project.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

//rest controller to handle http requests
@RestController
@RequestMapping ("/api/users") //base path for my endpoints
@CrossOrigin                   //allowing requests from frontend

public class UserController {
    private final UserRepository userRepository;

    //constructor injection for user repository
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //endpoint to create new user; POST /api/users
    //check if the email already exists, if not create a new user
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return userRepository.findByEmail(user.getEmail())
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok(userRepository.save(user)));
    }
    //endpoint to retrieve all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //endpoint to retrive one user by their ID; GET /api/users/{id}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    //endpoint to update user information; PUT /api/users/{id}
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id).orElseThrow(); //finding existing user in db
        user.setName(updatedUser.getName());                   //updating user;s fields with new values
        user.setEmail(updatedUser.getEmail());
        user.setInstitution(updatedUser.getInstitution());
        return userRepository.save(user);
    }
    //endpoint to delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}