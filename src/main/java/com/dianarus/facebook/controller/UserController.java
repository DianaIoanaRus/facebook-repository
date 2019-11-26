package com.dianarus.facebook.controller;

import com.dianarus.facebook.model.User;
import com.dianarus.facebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value = "/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        User user = userService.findUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }else{
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        }

    }


}
