package com.example.demo.Services;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.exception.ApiRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(int id) {

        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent())
        throw new ApiRequestException("User Not Found");

        return user;
    }

    public User save(User user) {

        return userRepository.save(user);
    }

    public void deleteOne(int id) {

        findById(id);

        // WIll trigger if about is not error
        userRepository.deleteById(id);
    }
}
