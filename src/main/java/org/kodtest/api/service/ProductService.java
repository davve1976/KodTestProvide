package org.kodtest.api.service;

import org.kodtest.api.model.Product;

import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public interface ProductService {

	Product getProductById(int id);

	List<Product> getAllProducts();

	List<Product> getAllProductsTest();

	Product getProductByIdTest(List<Product> products, int id);
}