package com.products.orders;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.products.orders.model.Product;
import com.products.orders.repository.ProductRepository;
import com.products.orders.service.ProductService;
import com.products.orders.service.ProductServiceImpl;

@RunWith(EasyMockRunner.class)
public class ProductsTests extends EasyMockSupport {

	@TestSubject
	ProductService productService = new ProductServiceImpl();

	@Mock
	ProductRepository productRepository;
	
	List<Product> list = new ArrayList<Product>();
	
	@Before
	public void setUp(){
		Product productBig = EasyMock.createMock(Product.class);
		productBig.setCode("b1");
		productBig.setName("big1");
		Product productSmall = EasyMock.createMock(Product.class);
		productBig.setCode("s1");
		productBig.setName("small1");
		list.add(productBig);
		list.add(productSmall);
	}
	
	@Test()
	public void productTest() {

		EasyMock.expect(productRepository.findAll()).andReturn(list);
		replayAll();

		List<Product> allProducts = productService.getAllProducts();
		verifyAll();
		Assert.assertNotNull(allProducts.get(0));
		Assert.assertEquals(allProducts.size(), 2);
		
	}

}
