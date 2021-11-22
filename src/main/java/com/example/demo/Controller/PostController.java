package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.Entity.Post;
import com.example.demo.Services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping(path = "/findone/{id}")
    public Post getPost(@PathVariable int id) {

        return postService.getPost(id);
    }

    @PostMapping(path = "/add/{id}")
    public Post CreatePost(@PathVariable int id, @RequestBody Post post) {

        return postService.createPost(id, post);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity DeletePost(@PathVariable int id) {

    postService.deletePost(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
