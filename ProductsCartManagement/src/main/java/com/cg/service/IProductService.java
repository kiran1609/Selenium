package com.cg.service;

import java.util.List;

import com.cg.models.Product;

public interface IProductService {

	public Product findByCode(int code);
	public void saveproduct(Product product);
	public List<Product> findAll();
	public void deleteproduct(int code);
	public void updateproduct(Product product);
}
