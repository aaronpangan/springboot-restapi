package com.example.demo.Controller;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping(path = "/getall")
    public List<UserEntity> getAll() {

        return userDao.findAll();
    }

    @GetMapping(path = "/get/{id}")
    public UserEntity getOne(@PathVariable int id) {
        return userDao.findById(id);

    }

    @PostMapping(path = "/add")

    public ResponseEntity<UserEntity> addUser(@Valid @RequestBody UserEntity user) {
        return new ResponseEntity<UserEntity>(userDao.saveOne(user), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")

    public ResponseEntity<UserEntity> deleteUser(@PathVariable int id) {
        return new ResponseEntity<UserEntity>(userDao.deleteById(id), HttpStatus.NO_CONTENT);
    }
}
