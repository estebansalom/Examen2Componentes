package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.websocket.server.PathParam;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@Controller
@RequestMapping(path = "api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<String> insertUser(@RequestBody User puser) {
        userService.createUser(puser);
        return ResponseEntity.ok("user created.");
    }

    @PutMapping
    public ResponseEntity<String> putUser(@RequestBody User puser) {
        String res = userService.editUser(puser);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> findById(@PathVariable("id") int id) throws IOException {
        int value = (int) id;
        return ResponseEntity.ok(userService.getUser(value));
    }

    @RequestMapping(value = "/billing/{text}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findByBillingAddress(@PathVariable("text") String param) throws IOException {
        return ResponseEntity.ok(userService.findByBillingAddressContaining(param));
    }

    @RequestMapping(value = "/lastName/{text}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findByLastName(@PathVariable("text") String param) throws IOException {
        return ResponseEntity.ok(userService.findByLastNameContaining(param));
    }
}
