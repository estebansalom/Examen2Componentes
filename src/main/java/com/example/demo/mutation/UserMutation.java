package com.example.demo.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutation implements GraphQLMutationResolver {
    @Autowired
    private UserService userService;

    public User createUser(String name, String lastName, String shippingAddress, String billingAddress,
            String cardNumber, String cardExpiration) {
        return userService.generateUser(name, lastName, shippingAddress, billingAddress, cardNumber, cardExpiration);
    }

    public User editUser(int id, String name, String lastName, String shippingAddress, String billingAddress,
            String cardNumber, String cardExpiration) {
        User u = new User(id, name, lastName, shippingAddress, billingAddress, cardNumber, cardExpiration);
        return userService.updateUser(u);
    }
}
