package com.example.proyectospring.controllers;


import com.example.proyectospring.config.JwtService;
import com.example.proyectospring.modelentity.AuthRequest;
import com.example.proyectospring.modelentity.UserInfo;
import com.example.proyectospring.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome, this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    // Solo los usuarios con el rol ROLE_USER pueden acceder a este endpoint
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/user/userProfile")
    public String userProfile() {
        System.out.println("User Profile");
        return "Welcome to User Profile";
    }

    // Solo los usuarios con el rol ROLE_ADMIN pueden acceder a este endpoint
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin/adminProfile")
    public String adminProfile() {
        System.out.println("Admin Profile");
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        System.out.println(authRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            System.out.println("exito");
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            System.out.println("fallo");
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
    @GetMapping("/getUserData")
    public String getUserData(@RequestHeader("Authorization") String token) {
        // Eliminar el prefijo "Bearer " del token si está presente
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        return jwtService.extractUsername(token);
    }
}
