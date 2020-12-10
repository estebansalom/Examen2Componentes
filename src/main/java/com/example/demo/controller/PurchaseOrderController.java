package com.example.demo.controller;

import java.util.List;

import com.example.demo.entities.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@Controller
@RequestMapping(path = "api/v1/po")
public class PurchaseOrderController {
    @Autowired
    PurchaseOrderService poService;
    
    @PostMapping
    public ResponseEntity<String> insertPurchaseOrders(@RequestBody PurchaseOrder po){
        String res = poService.createPurchaseOrder(po);
        return ResponseEntity.ok(res);
    }

    @PutMapping
    public ResponseEntity<String> putPurchaseOrder(@RequestBody PurchaseOrder po){
        String res = poService.editPurchaseOrder(po);
        return ResponseEntity.ok(res);
    }
    
    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllOrders(){
        return ResponseEntity.ok(poService.getAllPurchaseOrders());
    }
}
