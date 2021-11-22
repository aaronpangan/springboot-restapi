package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public List<Post> getAllPost() {

        return postRepository.findAll();
    }

    public Post createPost(int id, Post post) {

        Optional<User> user = userRepository.findById(id);

        return postRepository.save(post);

    }

}
