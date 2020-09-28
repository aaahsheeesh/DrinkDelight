package com.cg.drinkdelight.serviceTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.BeforeClass;

import com.cg.drinkdelight.entity.User;
import com.cg.drinkdelight.exception.ProductOrderException;
import com.cg.drinkdelight.repository.ProductOrderDao;
import com.cg.drinkdelight.service.ProductOrderService;

public class ProductOrderServiceTest {

	
	
	@Autowired
	private ProductOrderService service;

	@MockBean
	private ProductOrderDao repository;

	@SuppressWarnings("unused")
	private User user;

	@BeforeClass
	public void setUpClass() {
		user= new User();
		user.setEmail("dfdd@gmail.com");
		user.setPassword("554545");
		user.setPhone("8787261794");
		user.setUserId(123);
		user.setUserName("Shruti");
		
		/*user = new Order(123, new User(1, "Coca Cola", "8787261794", "Shru@1235667", "dwivedishruti98@gmail.com"),
				new Product("ProductId", "Coca Cola Soft Drink Bottles", 250),
				new Address("GomtiNagar", "Lucknow", "U.P.", "226017"));

		order = new Order(5000, new User(1, "Nestle Cold Coffee", "7275492853", "testing!2334", "testing@gmail.coml"),
				new Product("ProductId", "Nestle Drink Bottles", 250),
				new Address("Andheri", "Mumbai", "U.P.", "232227"));*/
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testToDeleteOrderForIdExisting() throws ProductOrderException {

		when(repository.existsById(123)).thenReturn(true);
		service.cancelOrder(123);
		verify(repository, times(1)).deleteById(123);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testToDeleteOrderForId_WrongId() throws ProductOrderException {

		when(repository.existsById(207)).thenReturn(false);
		assertFalse(repository.existsById(207));
	}
}
