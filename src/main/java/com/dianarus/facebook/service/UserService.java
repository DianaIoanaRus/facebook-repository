package com.dianarus.facebook.service;

import com.dianarus.facebook.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void deleteUser(int id);
    User createUser(User user);
    User findUserById(int id);
}
