package com.example.proyectospring.controllers;
import com.example.proyectospring.modelentity.Post;
import com.example.proyectospring.modelentity.User;
import com.example.proyectospring.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserControllerC {
    private final UserService userService;
    public UserControllerC(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setName(userDetails.getName());
            // Actualiza otros campos según sea necesario
            userService.saveUser(existingUser);
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.findUserById(id).isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get().getPosts());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/most-posts")
    public ResponseEntity<User> getUserWithMostPosts() {
        User user = userService.findUserWithMostPosts();
        return ResponseEntity.ok(user);
    }
    @GetMapping("/with-less-than-posts/{postCount}")
    public ResponseEntity<List<User>> getUsersWithLessThanPosts(@PathVariable Long postCount) {
        List<User> users = userService.findUsersWithLessThanPosts(postCount);
        return ResponseEntity.ok(users);
    }
}
