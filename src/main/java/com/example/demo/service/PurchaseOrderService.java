package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.PurchaseOrder;

public interface PurchaseOrderService {
    public List<PurchaseOrder> getAllPurchaseOrders();
    public String createPurchaseOrder(PurchaseOrder puser);
    public String editPurchaseOrder(PurchaseOrder puser);
}
