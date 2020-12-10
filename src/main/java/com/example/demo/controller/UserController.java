package com.example.demo.controller;

import java.util.List;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT} )
@Controller
@RequestMapping(path = "api/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    
    @PostMapping
    public void insertUser(@RequestBody User puser){
        userService.createUser(puser);
    }

    @PutMapping
    public ResponseEntity<String> putUser(@RequestBody User puser){
        String res = userService.editUser(puser);
        return ResponseEntity.ok(res);
    }
    
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
