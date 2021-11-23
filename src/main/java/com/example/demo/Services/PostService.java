package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Repository.PostRepository;
import com.example.demo.exception.ApiRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    public List<Post> getAllPost() {

        return postRepository.findAll();
    }

    public Post createPost(int id, Post post) {

        User user = userService.findById(id).get();

        post.setUser(user);

        return postRepository.save(post);

    }

    public Post getPost(int id) {

        Optional<Post> post = postRepository.findById(id);

        if (!post.isPresent())
            throw new ApiRequestException("Post Not Found");

        return post.get();
    }

    public void deletePost(int id) {

        Optional<Post> post = postRepository.findById(id);

        if (!post.isPresent())
            throw new ApiRequestException("Post Not Found");

        postRepository.deleteById(id);
    }

    public Post updatePost(Post post, int userid, int postid) {

        // Check if user exist
        Optional<User> user = userService.findById(userid);

        // Check if post exist
        Post findPost = getPost(postid);

        // Check if the user id match the foreign user id on post entity
        if (user.get().getId() != findPost.getUser().getId())
            throw new ApiRequestException("Post Not Yours");

        findPost.setDescription(post.getDescription());

        postRepository.save(findPost);
        return findPost;
    }
}
