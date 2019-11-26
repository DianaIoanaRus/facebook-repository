package com.dianarus.facebook.controller;

import com.dianarus.facebook.model.Post;
import com.dianarus.facebook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/all")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping(value = "/create")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id)
    {
        Post post = postService.findPostById(id);
        if(post == null){
            return ResponseEntity.notFound().build();
        }
        else {
            postService.deletePost(id);
            return ResponseEntity.ok().build();
        }

    }
}
