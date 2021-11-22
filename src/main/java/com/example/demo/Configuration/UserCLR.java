package com.example.demo.Configuration;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCLR implements CommandLineRunner {


    @Autowired
    private UserRepository userRepo;


    @Override
    public void run(String... args) throws Exception {
           userRepo.save(new User( "AAA", "AAAAAAAAAA"));
           userRepo.save(new User( "BBB", "BBBBBBBBB"));
           userRepo.save(new User( "CCC", "CCCCCCCCC"));


    }

}
