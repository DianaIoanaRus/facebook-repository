package com.dianarus.facebook.service;

import com.dianarus.facebook.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    void deletePost(int id);
    Post createPost(Post post);
    Post findPostById(int id);
    void deletePostByIdUser(int id);
}
