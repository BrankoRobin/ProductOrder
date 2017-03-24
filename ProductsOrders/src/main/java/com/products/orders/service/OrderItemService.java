package com.products.orders.service;

import com.products.orders.model.OrderItem;

public interface OrderItemService {

	OrderItem addNewOrder(String user, Long productId, Integer quantity);

}
