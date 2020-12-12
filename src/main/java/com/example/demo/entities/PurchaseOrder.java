package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "productType", nullable = false)
    private String productType;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name = "imageUrl", nullable = false)
    private String image_url;
    @Column(name = "customerID", nullable = false)
    private int customerID;

    public PurchaseOrder() {

    }

    public PurchaseOrder(@JsonProperty("id") int id, @JsonProperty("product_type") String productType,
            @JsonProperty("quantity") int quantity, @JsonProperty("image_url") String image_url,
            @JsonProperty("customer_id") int customerId) {
        this.id = id;
        this.customerID = customerId;
        this.productType = productType;
        this.quantity = quantity;
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
