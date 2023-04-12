package com.shoppingCart.service;

import com.shoppingCart.dao.Product;
import com.shoppingCart.repository.ProductRepository;
import com.shoppingCart.dao.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repo;
    public int add(Product p) {
        return 0;
    }


    public int remove(String id) {
        return 0;
    }


    public List<Product> listALL() {
        return repo.findAll();
    }


    public Product get(String id) {
        return repo.findById(id).get();

    }
}
