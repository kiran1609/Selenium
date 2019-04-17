package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IProductDAO;
import com.cg.models.Product;
import com.cg.util.NoProductFoundException;


@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired private IProductDAO dao;

	//implementation for finding product by using product id
	@Override
	public Product findByCode(int code) {
		// TODO Auto-generated method stub
		System.out.println("Invoking dao.findById "+code);
		Optional<Product> product = dao.findById(code);
		if(! product.isPresent()) {
			throw new NoProductFoundException(code);
		}
		return product.get();
	}
	
	//implementation for added product to save
	@Override
	public void saveproduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println("Invoking dao.save");
		dao.save(product);
		
	}
	
	//implementation for view products
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		System.out.println("Invoking dao.findAll");
		return dao.findAll();
	}
	
	// implementation for deleting product
	@Override
	public void deleteproduct(int code) {
		// TODO Auto-generated method stub
		int code1=code;
		System.out.println("Invoking dao.delete");
		dao.deleteById(code1);
		
	}
	
	//implementation fro updatingproduct

	@Override
	public void updateproduct(Product product) {
		// TODO Auto-generated method stub
		if(dao.existsById(product.getCode()))
		{
		dao.save(product);
		}
	}

}
