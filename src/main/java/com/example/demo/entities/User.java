package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "shippingAddress", nullable = false)
    private String shippingAddress;
    @Column(name = "billingAddress")
    private String billingAddress;
    @Column(name = "cardNumber", nullable = false)
    private String cardNumber;
    @Column(name = "cardExpiration", nullable = false)
    private String cardExpiration;

    public User() {

    }

    public User(@JsonProperty("id") int id, @JsonProperty("name") String name,
            @JsonProperty("last_name") String lastName, @JsonProperty("shipping_address") String shippingAddress,
            @JsonProperty("billing_address") String billingAddress, @JsonProperty("card_number") String cardNumber,
            @JsonProperty("card_expiration") String cardExpiration) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.cardNumber = cardNumber;
        this.cardExpiration = cardExpiration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiration() {
        return cardExpiration;
    }

    public void setCardExpiration(String cardExpiration) {
        this.cardExpiration = cardExpiration;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
