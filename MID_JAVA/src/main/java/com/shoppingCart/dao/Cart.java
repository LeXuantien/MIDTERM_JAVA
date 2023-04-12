package com.shoppingCart.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private String productId;
    private String name;
    private double price;
    private int qty=1;
}
