package com.shoppingCart.service;

import com.shoppingCart.dao.Cart;
import com.shoppingCart.repository.ShoppingCartRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Repository
public class ShoppingCartService implements ShoppingCartRepository {
    Map<String, Cart> maps=new HashMap<>();
    @Override
    public void add(Cart cart){
        Cart cartItem =maps.get(cart.getProductId());
        if(cartItem==null){
            maps.put(cart.getProductId(),cart);
        }else {
            cartItem.setQty(cartItem.getQty()+1);
        }
    }
    @Override
    public void remove(String id){
        maps.remove(id);
    }
    @Override
    public Cart update( String proID, int qty){
        Cart cart=maps.get(proID);
        cart.setQty(qty);
        return cart;
    }
    @Override
    public  void clear(){
        maps.clear();
    }
    @Override
    public Collection<Cart> getALllCart(){
        return maps.values();
    }
    @Override
    public int getCount(){
        return maps.values().size();
    }
    @Override
    public double getAmount(){
        return maps.values().stream().mapToDouble(cart -> cart.getQty()*cart.getPrice()).sum();
    }
}
