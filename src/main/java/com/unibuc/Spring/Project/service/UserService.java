package com.unibuc.Spring.Project.service;

import com.unibuc.Spring.Project.exception.EmailAlreadyInUseException;
import com.unibuc.Spring.Project.exception.UsernameAlreadyInUseException;
import com.unibuc.Spring.Project.model.User;
import com.unibuc.Spring.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        Optional<User> userWithSameUsername = userRepository.findByUsername(user.getUsername());
        if(userWithSameUsername.isPresent()){
            throw new UsernameAlreadyInUseException();
        }
        Optional<User> userWithSameEmail = userRepository.findByEmail(user.getEmail());
        if(userWithSameEmail.isPresent()){
            throw new EmailAlreadyInUseException();
        }
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            // Set other fields as needed
            return userRepository.save(user);
        }
        else {
            throw new UsernameAlreadyInUseException();
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }



}
