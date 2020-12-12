package com.example.demo.repository;

import java.util.List;

import com.example.demo.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findById(int id);

    public List<User> findByLastNameContaining(String param);

    public List<User> findByBillingAddressContaining(String param);
}
