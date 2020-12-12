package com.example.demo.repository;

import java.util.List;

import com.example.demo.entities.PurchaseOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {
    public PurchaseOrder findById(int id);

    public List<PurchaseOrder> findByProductType(int id);
}
