package com.absa.application.phonebook.service;

import com.absa.application.phonebook.model.User;
import com.absa.application.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public User updateUser(int id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setMobile(user.getMobile());
            userRepository.save(existingUser);
        }
        return existingUser;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}