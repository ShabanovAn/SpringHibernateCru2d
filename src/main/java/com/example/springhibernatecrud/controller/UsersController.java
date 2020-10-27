package com.example.springhibernatecrud.controller;

import com.example.springhibernatecrud.model.User;
import com.example.springhibernatecrud.reposytory.UsersReposytory;
import com.example.springhibernatecrud.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@AllArgsConstructor
public class UsersController {
    UsersReposytory usersReposytory;
    UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.add(user);
    }

    @GetMapping
    public List<User> getAll() {
       // usersReposytory.callProcedure(5);
        return usersReposytory.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) throws ExecutionException, InterruptedException {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) throws ExecutionException, InterruptedException {
        userService.removeByID(id);
    }

//    @PutMapping("/{id}")
//    public User updateUser(@RequestBody User user, @PathVariable int id) {
//        return usersReposytory.updateUser(user, id);
//    }
}
