package com.unibuc.Spring.Project.Controller;

import com.unibuc.Spring.Project.dto.auth.LoginRequest;
import com.unibuc.Spring.Project.dto.auth.RegisterRequest;
import com.unibuc.Spring.Project.exception.auth.PasswordIncorrectException;
import com.unibuc.Spring.Project.model.User;
import com.unibuc.Spring.Project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest registerRequest){
        User newUser = new User(registerRequest.getUsername(), registerRequest.getEmail(), registerRequest.getPassword());

        userService.createUser(newUser);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/");

        return ResponseEntity
                .status(200)
                .headers(headers)
                .body("User " + registerRequest.getUsername() + " has been created successfully");
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest){
        User user = userService.getUserByUsername(loginRequest.getUsername());

        if(loginRequest.getPassword().equals(user.getPassword())){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/");

            return ResponseEntity
                    .status(200)
                    .headers(headers)
                    .body("You logged in successfully");
        } else {
            throw new PasswordIncorrectException();
        }
    }
}
