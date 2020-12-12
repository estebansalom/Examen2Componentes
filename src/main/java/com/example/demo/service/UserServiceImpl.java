package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void createUser(User puser) {
        userRepo.save(puser);
    }

    @Override
    public String editUser(User puser) {
        User existingUser = userRepo.findById(puser.getId());
        if (existingUser != null) {
            userRepo.save(puser);
            return "success";
        } else {
            return "failed edit";
        }

    }

    @Override
    public User getUser(int id) {
        return userRepo.findById(id);
    }

    @Override
    public User generateUser(String name, String lastName, String shippingAddress, String billingAddress,
            String cardNumber, String cardExpiration) {
        return userRepo.save(new User(name, lastName, shippingAddress, billingAddress, cardNumber, cardExpiration));
    }

    @Override
    public List<User> findByLastNameContaining(String param) {
        return userRepo.findByLastNameContaining(param);
    }

    @Override
    public List<User> findByBillingAddressContaining(String param) {
        return userRepo.findByBillingAddressContaining(param);
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);

    }

}
