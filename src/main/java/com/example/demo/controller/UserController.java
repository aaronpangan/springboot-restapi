package com.example.demo.controller;

import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping(path = "/getall")
    public List<UserModel> getAll() {
        return userDao.findAll();
    }

    @GetMapping(path = "/get/{id}")
    public UserModel getOne(@PathVariable int id) {
        return userDao.findOne(id);

    }

    @PostMapping(path = "/add")

    public ResponseEntity<UserModel> addUser(@RequestBody UserModel user) {
        return new ResponseEntity<UserModel>(userDao.saveOne(user), HttpStatus.CREATED);
    }
}
