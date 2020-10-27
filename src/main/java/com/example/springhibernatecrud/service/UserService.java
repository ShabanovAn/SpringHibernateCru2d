package com.example.springhibernatecrud.service;

import com.example.springhibernatecrud.model.User;
import com.example.springhibernatecrud.reposytory.UsersReposytory;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
@AllArgsConstructor
public class UserService {
    UsersReposytory usersReposytory;

    public User add(User user) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<User> future = executorService.submit(() -> usersReposytory.add(user));
        executorService.shutdown();
        return future.get();
    }


    public User getById(int id) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<User> future = executorService.submit(()->usersReposytory.getById(id));
        executorService.shutdown();
        return future.get();
    }

    public void removeByID(int id) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(()->usersReposytory.removeById(id));
        executorService.shutdown();

    }

}
