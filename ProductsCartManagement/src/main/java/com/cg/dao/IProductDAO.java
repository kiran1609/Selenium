package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.models.Product;

public interface IProductDAO extends JpaRepository<Product,Integer> {

}
