package com.example.demo.query;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserQuery implements GraphQLQueryResolver {
	@Autowired
	 private UserService userService;
	
	 public List<User> getUsers(int count) {
	 return this.userService.getAllUsers();
	 }
	 
	 public User getUser(int id) {
	 return this.userService.getUser(id);
	 }
}
