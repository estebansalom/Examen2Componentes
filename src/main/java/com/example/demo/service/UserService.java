package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {
    public List<User> getAllUsers();
    public void createUser(User puser);
    public String editUser(User puser);
    public User getUser(int id);
    public User generateUser(String name, String lastName, String shippingAddress, String billingAddress, String cardNumber, String cardExpiration);
}
