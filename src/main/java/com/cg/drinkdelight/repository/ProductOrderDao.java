package com.cg.drinkdelight.repository;

import com.cg.drinkdelight.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductOrderDao  extends JpaRepository<Order,Integer> {

	
	List<Order> findByOrderId(Integer orderId);
	List<Order> findByUserId(Integer userId);
}
