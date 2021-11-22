package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.Entity.Post;
import com.example.demo.Services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping(path = "/findall")
    public List<Post> getAllPost() {

        return postService.getAllPost();
    }

    @PostMapping(path = "/add/{id}")
    public Post CreatePost(@PathVariable int id, @RequestBody Post post) {

        return postService.createPost(id, post);
    }

}
