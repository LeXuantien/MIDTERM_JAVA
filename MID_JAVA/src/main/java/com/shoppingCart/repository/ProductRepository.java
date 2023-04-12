package com.shoppingCart.repository;
import  com.shoppingCart.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, String> {

    Product get(String id);
}
