package com.example.demo.controller;


import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserDao;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
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


    public UserModel addUser(@RequestBody UserModel user) {
        return userDao.saveOne(user);
    }
}
