package com.example.demo.repository;

import com.example.demo.entities.PurchaseOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {
    public PurchaseOrder findById(int id);
}
