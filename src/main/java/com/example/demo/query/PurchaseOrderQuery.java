package com.example.demo.query;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.entities.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderQuery implements GraphQLQueryResolver{
    @Autowired
	 private PurchaseOrderService poService;
	
	 public List<PurchaseOrder> getPurchaseOrders(int count) {
	 return this.poService.getAllPurchaseOrders();
	 }
	 
	 public PurchaseOrder getPurchaseOrder(int id) {
	 return this.poService.getById(id);
	 }
}
