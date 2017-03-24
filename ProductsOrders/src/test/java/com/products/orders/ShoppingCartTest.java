package com.products.orders;

import java.util.HashSet;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.IAnswer;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.products.orders.model.OrderItem;
import com.products.orders.model.ShoppingCart;
import com.products.orders.repository.ShoppingCartRepository;
import com.products.orders.service.ShoppingCartService;
import com.products.orders.service.ShoppingCartServiceImpl;

@RunWith(EasyMockRunner.class)
public class ShoppingCartTest extends EasyMockSupport {

	@TestSubject
	ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

	@Mock
	ShoppingCartRepository shoppingCartRepository;

	@Test()
	public void shoppingCartTest() {

		EasyMock.expect(shoppingCartRepository.findOneByUser("bestUser")).andReturn(null);
		ShoppingCart shoppingCart = EasyMock.createMock(ShoppingCart.class);
		shoppingCart.setUser("bestUser");
		shoppingCart.setOrders(new HashSet<OrderItem>());

		final Capture<ShoppingCart> capture = new Capture<ShoppingCart>();
		EasyMock.expect(shoppingCartRepository.save(EasyMock.capture(capture))).andAnswer(new IAnswer<ShoppingCart>() {
			@Override
			public ShoppingCart answer() throws Throwable {
				ShoppingCart shoppingCart = capture.getValue();
				shoppingCart.setId(1L);
				return shoppingCart;
			}
		});
		replayAll();

		ShoppingCart shoppingCartForUser = shoppingCartService.getShoppingCartForUser("bestUser");
		verifyAll();
		Assert.assertNotNull(shoppingCartForUser);

	}

}
