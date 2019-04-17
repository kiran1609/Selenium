package com.cg.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.models.Product;
import com.cg.service.IProductService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/product")
public class ProductController {
@Autowired private IProductService service;
	
	@RequestMapping("/find/{id}")
	
	
	//1....// URL http://localhost:5000/product/find/Id 
	
	public Product findById(@PathVariable("id") int code) {
		return service.findByCode(code);
	}
	
	@RequestMapping(value="/find-all",
			produces= {"application/json"})
	
	//2..// URL http://localhost:5000/product/find-all
	public List<Product> findAll(){
		return service.findAll();
		
	}
	
	//3..// POST http://localhost:5000/product/add
	
		// Request Body must contain JSON data!
		@RequestMapping(value="/add",
				method=RequestMethod.POST,
				consumes="application/json")
		public ResponseEntity<String> save(@RequestBody Product product){
			System.out.println("About to save new product");
			service.saveproduct(product);
			return new ResponseEntity<>("Product Created!",HttpStatus.OK);
		}
		
		//4..// delete http://localhost:5000/product/delete?id=
		
		
		@RequestMapping(value="/delete",method=RequestMethod.DELETE)
		public ResponseEntity<String> deleteById(@RequestParam("id")int code){
			System.out.println("Deleting product");
			service.deleteproduct(code);
			return new ResponseEntity<>("deleted!",HttpStatus.OK);
		}

		//5..// put http://localhost:5000/product/update
		
		
		@RequestMapping(value="/update",method=RequestMethod.PUT,consumes="application/json")
		public ResponseEntity<String> update(@RequestBody Product product)
		{
			System.out.println("Updating product");
			service.saveproduct(product);
			return new ResponseEntity<>("Updated",HttpStatus.OK);
		}
}
