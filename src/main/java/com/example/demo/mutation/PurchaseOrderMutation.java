package com.example.demo.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.entities.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderMutation implements GraphQLMutationResolver {
    @Autowired
	private PurchaseOrderService poService;

	public PurchaseOrder createPurchaseOrder(String productType, int quantity, String imageUrl, int customerID) {
        return poService.generatePurchaseOrder(productType, quantity, imageUrl, customerID);
	}
}
