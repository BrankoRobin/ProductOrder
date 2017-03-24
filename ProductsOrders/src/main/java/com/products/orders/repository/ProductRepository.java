package com.products.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.products.orders.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
