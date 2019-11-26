package com.dianarus.facebook.service.impl;

import com.dianarus.facebook.model.Post;
import com.dianarus.facebook.repository.PostRepository;
import com.dianarus.facebook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void deletePost(int id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findPostById(int id) {
        return postRepository.findPostById(id);
    }

    @Override
    public void deletePostByIdUser(int idUser) {
        List<Post> postList = getAllPosts();
        for(Post post: postList){
            if( post.getUser().getId() == idUser){
                deletePost(post.getId());
            }
        }

    }
}
