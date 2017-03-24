package com.products.orders.service;

import com.products.orders.model.ShoppingCart;

public interface ShoppingCartService {

	ShoppingCart getShoppingCartForUser(String user);

}
