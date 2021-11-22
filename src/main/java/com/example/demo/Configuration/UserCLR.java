package com.example.demo.Configuration;

import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCLR implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostRepository postRepo;

    @Override
    public void run(String... args) throws Exception {
        User user1 = userRepo.save(new User("AAA", "AAAAAAAAAA"));
        User user2 = userRepo.save(new User("BBB", "BBBBBBBBB"));
        User user3 = userRepo.save(new User("CCC", "CCCCCCCCC"));

        postRepo.save(new Post("Sample Desc1", user1));
        postRepo.save(new Post("Sample Desc2", user2));
        postRepo.save(new Post("Sample Desc3", user3));

    }

}
