package com.dianarus.facebook.service.impl;

import com.dianarus.facebook.model.Post;
import com.dianarus.facebook.model.User;
import com.dianarus.facebook.repository.UserRepository;
import com.dianarus.facebook.service.PostService;
import com.dianarus.facebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostService postService;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int id) {
        postService.deletePostByIdUser(id);
        userRepository.deleteById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }
}
