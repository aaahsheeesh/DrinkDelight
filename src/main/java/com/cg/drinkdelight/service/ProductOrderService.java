package com.cg.drinkdelight.service;

import java.util.List;

import com.cg.drinkdelight.exception.ProductOrderException;
import com.cg.drinkdelight.model.OrderModel;
import com.cg.drinkdelight.model.ProductModel;
import com.sun.el.stream.Optional;
import java.util.*;

public interface ProductOrderService {

	public ProductModel addProductList(ProductModel productList) throws ProductOrderException;

	public List<ProductModel> viewProductList() throws ProductOrderException;

	public OrderModel placeOrder(OrderModel order) throws ProductOrderException;

	public List<OrderModel> orderSummary(Integer orderId) throws ProductOrderException;

	public String cancelOrder(Integer orderId) throws ProductOrderException;

	public List<OrderModel> trackProductOrder(Integer orderId) throws ProductOrderException;

}
