package com.example.inkagenda.controller;

import com.example.inkagenda.model.User;
import com.example.inkagenda.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>>getAllUser(){
        return   ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id){
        return new ResponseEntity<User>(userService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/admin/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
