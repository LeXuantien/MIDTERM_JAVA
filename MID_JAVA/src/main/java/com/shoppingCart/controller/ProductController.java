package com.shoppingCart.controller;

import com.shoppingCart.dao.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;
    @RequestMapping("/")
    public String viewProducts(Model model){
        List<Product> listProducts = service.listALL();
        model.addAttribute("List_product", listProducts);
        return ("view_products");

    }
}
