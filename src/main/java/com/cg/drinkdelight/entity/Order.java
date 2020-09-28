package com.cg.drinkdelight.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private LocalDate orderDate;
    private Integer price;
    private Integer quantity;
   
    
  //  @OneToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "userId", nullable = false)
    private String userId;


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order() {
    }

    public Order(int orderId, LocalDate orderDate, int price, int quantity) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.price = price;
        this.quantity = quantity;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
