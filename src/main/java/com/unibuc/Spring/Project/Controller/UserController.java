package com.unibuc.Spring.Project.Controller;

import com.unibuc.Spring.Project.dto.user.CreateUserRequest;
import com.unibuc.Spring.Project.dto.user.DeleteUserRequest;
import com.unibuc.Spring.Project.model.User;
import com.unibuc.Spring.Project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid CreateUserRequest createUserRequest){
        User newUser = new User(createUserRequest.getUsername(), createUserRequest.getEmail(), createUserRequest.getPassword());

        User createdUser = userService.createUser(newUser);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody @Valid DeleteUserRequest deleteUserRequest){
        User user = userService.getUserByUsername(deleteUserRequest.getUsername());

        userService.deleteUser(user.getUsername());
        return ResponseEntity.status(200).body("User was deleted");
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
