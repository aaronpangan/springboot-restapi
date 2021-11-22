package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.exception.ApiRequestException;

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

        Optional<User> findUser = userRepository.findById(id);

        if (!findUser.isPresent())
            throw new ApiRequestException("User Not Found");

        User user = findUser.get();

        post.setUser(user);

        return postRepository.save(post);

    }

    public Post getPost(int id) {

        Optional<Post> post = postRepository.findById(id);

        if (!post.isPresent())
            throw new ApiRequestException("Post Not Found");

        return post.get();
    }

    public void deletePost(int id){

        Optional<Post> post = postRepository.findById(id);

        if (!post.isPresent())
            throw new ApiRequestException("Post Not Found");

        postRepository.deleteById(id);
    }
}
