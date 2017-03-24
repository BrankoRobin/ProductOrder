package com.products.orders.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.orders.model.OrderItem;
import com.products.orders.model.ShoppingCart;
import com.products.orders.repository.OrderItemRepository;
import com.products.orders.repository.ProductRepository;
import com.products.orders.repository.ShoppingCartRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	private static final Logger log = LoggerFactory.getLogger(OrderItemServiceImpl.class);

	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderItemRepository singleOrderRepository;

	@Override
	public OrderItem addNewOrder(String user, Long productId, Integer quantity) {
		log.info("Finding ShoppingCart for user {}.",user);
		ShoppingCart shpingCartForUser = shoppingCartRepository.findOneByUser(user);
		log.info("Creting new OrderItem.");
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(productRepository.findOne(productId));
		orderItem.setQuantity(quantity);
		log.info("Adding OrderItem to ShoppingCart");
		shpingCartForUser.getOrders().add(singleOrderRepository.save(orderItem));
		return singleOrderRepository.save(orderItem);
	}

}
