package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {
    public List<User> getAllUsers();

    public void createUser(User puser);

    public String editUser(User puser);

    public User getUser(int id);

    public void deleteUser(int id);

    public List<User> findByLastNameContaining(String param);

    public List<User> findByBillingAddressContaining(String param);

    public User generateUser(String name, String lastName, String shippingAddress, String billingAddress,
            String cardNumber, String cardExpiration);
}
