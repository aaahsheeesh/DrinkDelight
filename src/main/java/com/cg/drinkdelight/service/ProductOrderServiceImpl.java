package com.cg.drinkdelight.service;

import java.util.*;
import java.util.stream.Collectors;

import com.cg.drinkdelight.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drinkdelight.entity.Order;
import com.cg.drinkdelight.entity.Product;
import com.cg.drinkdelight.exception.ProductOrderException;
import com.cg.drinkdelight.model.OrderModel;
import com.cg.drinkdelight.model.ProductModel;
import com.cg.drinkdelight.repository.ProductDao;
import com.cg.drinkdelight.repository.ProductOrderDao;
import com.cg.drinkdelight.repository.UserDao;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

	@Autowired
	private ProductOrderDao repository;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductDao productDao;

	private Order of(OrderModel source) {
		Order entity = null;
		if (source != null) {
			entity = new Order();

			entity.setOrderDate(source.getOrderDate());
			entity.setOrderId(source.getOrderId());
			entity.setPrice(source.getPrice());
			entity.setQuantity(source.getQuantity());

		}
		return entity;
	}

	private OrderModel of(Order source) {
		OrderModel model = null;
		if (source != null) {
			model = new OrderModel();
			model.setOrderDate(source.getOrderDate());
			model.setOrderId(source.getOrderId());
			model.setPrice(source.getPrice());
			model.setQuantity(source.getQuantity());

		}
		return model;
	}

	private ProductModel of(Product source) {
		ProductModel model = null;
		if (source != null) {
			model = new ProductModel();
			model.setExpiryDate(source.getExpiryDate());
			model.setId(source.getId());
			model.setManufacturingDate(source.getManufacturingDate());
			model.setName(source.getName());
			model.setQuantity(source.getQuantity());
			model.setPrice(source.getPrice());
		}
		return model;
	}

	private Product of(ProductModel source) {
		Product entity = null;
		if (source != null) {
			entity = new Product();
			entity.setExpiryDate(source.getExpiryDate());
			entity.setId(source.getId());
			entity.setManufacturingDate(source.getManufacturingDate());
			entity.setName(source.getName());
			entity.setQuantity(source.getQuantity());
			entity.setPrice(source.getPrice());
		}
		return entity;
	}

	// MANUALLY SETTING SOME PRODUCTS TO DATABASE
	@Override
	public ProductModel addProductList(ProductModel productList) throws ProductOrderException {
		return of(productDao.save(of(productList)));//product linking

	}

	// TO SHOW LIST OF PRODUCTS AVAILABLE

	@Override
	public List<ProductModel> viewProductList() throws ProductOrderException {
		List<Product> list = (List<Product>) productDao.findAll();
		return list.stream().map(entity -> of(entity)).collect(Collectors.toList());//product link

	}

	// USER CAN PLACE ORDER
	@Override
	public OrderModel placeOrder(OrderModel order) throws ProductOrderException {
		return of(repository.save(of(order))); //order place save hoga user...
		//userrepo use krni hai????

	}

	// USER CAN CHECK ORDER DETAILS
	@Override
	public List<OrderModel> orderSummary(Integer userId) throws ProductOrderException {
		List<OrderModel> list = null;
		if (!userDao.existsById(userId))
			throw new ProductOrderException("No Orders Available");
		else {
			User user = userDao.findById(userId).orElse(null);

			if (user != null) {
				list = repository.findByUserId(userId).stream().map(entity -> of(entity)).collect(Collectors.toList());
			}

		}

		return list;
	}

	// USER CAN CANCEL ORDER
	@Override
	public String cancelOrder(Integer orderId) throws ProductOrderException {
		if (!repository.existsById(orderId)) {
			throw new ProductOrderException("Order  Id does not exist!");
		}

		repository.deleteById(orderId);
		return "Order Cancelled Succesfully";

	}

	// USER CAN TRACK ORDER ON THE BASIS OF ORDER ID
	@Override
	public List<OrderModel> trackProductOrder(Integer orderId) throws ProductOrderException {
		List<OrderModel> productModelList = null;
		List<Order> productEntityList = repository.findByOrderId(orderId);
		int id = 0;

		for (Order productEntity : productEntityList) {
			id = productEntity.getOrderId();
		}

		if (productEntityList != null && orderId == id) {
			productModelList = productEntityList.stream().map(p -> of(p)).collect(Collectors.toList());
		}

		return productModelList;
	}

}
