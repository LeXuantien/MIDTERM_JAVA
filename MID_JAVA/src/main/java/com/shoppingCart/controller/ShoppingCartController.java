package com.shoppingCart.controller;

import com.shoppingCart.dao.Cart;
import com.shoppingCart.dao.Product;
import com.shoppingCart.repository.ProductRepository;
import com.shoppingCart.repository.ShoppingCartRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shopping-cart")
public class ShoppingCartController {
    ProductRepository repo;
    ShoppingCartRepository shoppingrepo;
    public String viewCart(Model model){
        model.addAttribute("CART_ITEMS",shoppingrepo.getALllCart());
        model.addAttribute("TOTAL",shoppingrepo.getAmount());
        return "cart";
    }
    @GetMapping("add/{id}")
    public String addCart(@PathVariable("id") String id){
        Product product=repo.get(id);
        if(product==null){
            Cart item=new Cart();
            item.setProductId(product.getId());
            item.setName(product.getName());
            item.setPrice(product.getPrice());
            item.setQty(1);
            shoppingrepo.add(item);

        }
        return"redirect:/shopping-cart/";
    }
    @GetMapping("clear")
    public String clearCart(){
        shoppingrepo.clear();
        return"redirect:/shopping-cart/";
    }
    @GetMapping("detele/{id}")
    public String removeCart(@PathVariable("id") String id){
        shoppingrepo.remove(id);
        return"redirect:/shopping-cart/";
    }

}
