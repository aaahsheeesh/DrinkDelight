/*
 * 
 * @Author Capegemini
 * @Developer Shruti Dwivedi
 * @Description This class is Controller class handling all the request coming from the client side at at the
 *  URL :-http://localhost7700/userProductOrder
 * @Created 25/09/2020
 * @Version 1.0
 *
 *
 */

package com.cg.drinkdelight.controller;

import com.cg.drinkdelight.exception.ProductOrderException;
import com.cg.drinkdelight.model.OrderModel;
import com.cg.drinkdelight.model.ProductModel;
import com.cg.drinkdelight.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductOrderController {

	@Autowired
	private ProductOrderService service;

	@GetMapping("/getproductlist")
	public ResponseEntity<List<ProductModel>> getProductlist() throws ProductOrderException {
		List<ProductModel> list = service.viewProductList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("/addproductlist")
	public ResponseEntity<ProductModel> addProductList(@RequestBody ProductModel product) throws ProductOrderException {
		product = service.addProductList(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PostMapping("/placeorder")
	public ResponseEntity<OrderModel> placeOrder(@RequestBody OrderModel order) throws ProductOrderException {
		order = service.placeOrder(order);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@DeleteMapping("/cancelorder/{orderId}")
	public ResponseEntity<String> cancelOrder(@PathVariable("orderId") Integer orderId) throws ProductOrderException {
		String message = service.cancelOrder(orderId);
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@GetMapping("/vieworderdetails/{userId}")
	public ResponseEntity<List<OrderModel>> findAll(@PathVariable("userId") Integer userId)
			throws ProductOrderException {
		return new ResponseEntity<>(service.orderSummary(userId), HttpStatus.OK);
	}

	@GetMapping("/trackorder/{orderId}")
	public ResponseEntity<List<OrderModel>> trackProductOrder(@PathVariable("orderId") Integer orderId)
			throws ProductOrderException {
		List<OrderModel> modelList = service.trackProductOrder(orderId);
		return new ResponseEntity<>(modelList, HttpStatus.OK);

	}
}
