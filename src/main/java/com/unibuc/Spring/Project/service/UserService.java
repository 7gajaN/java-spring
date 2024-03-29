package com.unibuc.Spring.Project.service;

import com.unibuc.Spring.Project.exception.user.EmailAlreadyInUseException;
import com.unibuc.Spring.Project.exception.user.UsernameAlreadyInUseException;
import com.unibuc.Spring.Project.model.User;
import com.unibuc.Spring.Project.repository.OrderRepository;
import com.unibuc.Spring.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    public User createUser(User user){
        User userWithSameUsername = userRepository.findByUsername(user.getUsername());
        if(userWithSameUsername != null){
            throw new UsernameAlreadyInUseException();
        }
        User userWithSameEmail = userRepository.findByEmail(user.getEmail());
        if(userWithSameEmail != null){
            throw new EmailAlreadyInUseException();
        }
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByEmail(String email) {
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
            return userRepository.save(user);
        }
        else {
            throw new UsernameAlreadyInUseException();
        }
    }

    public void deleteUser(String username) {
        User user = getUserByUsername(username);
        userRepository.delete(user);
    }



}
