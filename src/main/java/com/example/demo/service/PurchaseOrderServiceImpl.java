package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.PurchaseOrder;
import com.example.demo.entities.User;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    PurchaseOrderRepository poRepo;
    @Autowired
    UserRepository userRepo;

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return poRepo.findAll();
    }

    @Override
    public String createPurchaseOrder(PurchaseOrder po) {
        User existingUser = userRepo.findById(po.getCustomerID());
        if (existingUser != null) {
            poRepo.save(po);
            return "success";
        } else {
            return "fail, user doesn't exist.";
        }

    }

    @Override
    public String editPurchaseOrder(PurchaseOrder po) {
        PurchaseOrder existingOrder = poRepo.findById(po.getId());
        if (existingOrder != null) {
            poRepo.save(po);
            return "success";
        } else {
            return "failed edit";
        }
    }

    public PurchaseOrder getById(int id) {
        return poRepo.getOne(id);
    }

    @Override
    public PurchaseOrder generatePurchaseOrder(String productType, int quantity, String imageUrl, int customerID) {
        return poRepo.save(new PurchaseOrder(productType, quantity, imageUrl, customerID));
    }

    @Override
    public List<PurchaseOrder> findByProductType(int id) {
        return poRepo.findByProductType(id);
    }

}
