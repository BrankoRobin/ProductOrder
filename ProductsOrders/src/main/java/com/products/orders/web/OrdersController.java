package com.products.orders.web;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.orders.model.OrderItem;
import com.products.orders.model.Product;
import com.products.orders.model.ShoppingCart;
import com.products.orders.model.dto.NewOrderDto;
import com.products.orders.service.OrderItemService;
import com.products.orders.service.ProductService;
import com.products.orders.service.ShoppingCartService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	private static final Logger log = LoggerFactory.getLogger(OrdersController.class);

	@Autowired
	ProductService productService;

	@Autowired
	ShoppingCartService shoppingCartService;

	@Autowired
	OrderItemService orderItemService;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		log.info("Calling getAllProducts");
		return productService.getAllProducts();
	}

	@GetMapping("/shopping-cart")
	public ShoppingCart getShoppingCart(Principal principal) {
		log.info("Calling getShoppingCart");
		return shoppingCartService.getShoppingCartForUser(principal.getName());
	}

	@PostMapping("/add-new-order")
	public OrderItem addNewOrder(Principal principal, @Valid NewOrderDto newOrder) {
		log.info("Calling addNewOrder");
		return orderItemService.addNewOrder(principal.getName(), newOrder.getProductId(), newOrder.getQuantity());
	}

}
