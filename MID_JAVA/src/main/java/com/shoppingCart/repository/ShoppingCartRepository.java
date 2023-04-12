package com.shoppingCart.repository;

import com.shoppingCart.dao.Cart;

import java.util.Collection;

public interface ShoppingCartRepository {

    void add(Cart cart);

    void remove(String id);

    Cart update(String proID, int qty);

    void clear();

    Collection<Cart> getALllCart();

    int getCount();

    double getAmount();
}
