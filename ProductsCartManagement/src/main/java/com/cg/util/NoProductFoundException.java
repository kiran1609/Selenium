package com.cg.util;


//user defined exception class for finding the product details
public class NoProductFoundException extends RuntimeException {
	
	public NoProductFoundException(int productCode) {
		super("Product with code "+productCode+" does not exists!");
		
	}

}
