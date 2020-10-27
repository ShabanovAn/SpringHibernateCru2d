package com.example.springhibernatecrud.controller;

import com.example.springhibernatecrud.model.JpaUser;
import com.example.springhibernatecrud.reposytory.JpaUserReposytory;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Jpa")
@AllArgsConstructor
public class JpaUserController {
    JpaUserReposytory jpaUserReposytory;

    @GetMapping
    public List<JpaUser> getALlJpa () {
     return jpaUserReposytory.getAllJpa();
    }

    @PostMapping
    public JpaUser createUserJpa(@RequestBody JpaUser jpaUser) {
        return jpaUserReposytory.addJpa(jpaUser);
    }

    @DeleteMapping("/{id}")
    public void deleteJpaUser(@PathVariable int id) {
        jpaUserReposytory.deleteJpaUser(id);
    }

    @GetMapping("/j") //localhost:8081/Jpa/j?id=1
    public JpaUser getJpaUserId(@RequestParam int id, @RequestParam String name) {
        System.out.println(name);
        return jpaUserReposytory.getJpaUserId(id);
    }

//    @GetMapping("/j") //localhost:8081/Jpa/j/1
//    public JpaUser getJpaUserId2(@PathVariable int id) {
//        return jpaUserReposytory.getJpaUserId(id);
//    }

    @PutMapping("/up/{id}")
    public JpaUser updateJpaUserId(@RequestBody JpaUser jpaUser, @PathVariable int id) {
        return jpaUserReposytory.updateJpaUser(jpaUser, id);
    }

}


