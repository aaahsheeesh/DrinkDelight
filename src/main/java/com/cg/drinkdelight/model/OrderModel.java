package com.cg.drinkdelight.model;

import java.time.LocalDate;
import java.util.Date;

import com.cg.drinkdelight.entity.Address;
import com.cg.drinkdelight.entity.Product;
import com.cg.drinkdelight.entity.User;

public class OrderModel {

    private int orderId;
    private LocalDate orderDate;
    private int price;
    private int quantity;

    public OrderModel() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
