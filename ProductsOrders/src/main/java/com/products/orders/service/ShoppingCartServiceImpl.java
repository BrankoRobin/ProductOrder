package com.products.orders.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.orders.model.ShoppingCart;
import com.products.orders.model.OrderItem;
import com.products.orders.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	@Override
	public ShoppingCart getShoppingCartForUser(String user) {
		ShoppingCart shpingCartForUser = shoppingCartRepository.findOneByUser(user);
		if (shpingCartForUser == null) {
			shpingCartForUser = new ShoppingCart();
			shpingCartForUser.setUser(user);
			shpingCartForUser.setOrders(new HashSet<OrderItem>());
		}
		return shoppingCartRepository.save(shpingCartForUser);
	}

}
