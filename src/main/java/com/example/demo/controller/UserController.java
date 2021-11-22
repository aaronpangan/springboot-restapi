package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/getall")
    public List<User> getAll() {

        return userService.findAll();
    }

    @GetMapping(path = "/get/{id}")
    public Optional<User> getOne(@PathVariable int id) {
        return userService.findById(id);

    }

    @PostMapping(path = "/add")

    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")

    public ResponseEntity deleteUser(@PathVariable int id) {

        userService.deleteOne(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
