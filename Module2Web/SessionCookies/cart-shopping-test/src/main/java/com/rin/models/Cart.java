package com.rin.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<Product, Long> cart;
    public Cart() {
        cart = new HashMap<>();
    }
    public void addToCart(Product product, long quantityCustom) {
        if (cart.containsKey(product)) {
            cart.replace(product, cart.get(product), cart.get(product) + quantityCustom);
        } else {
            cart.put(product, quantityCustom);
        }
    }

    public void removeProduct(Product product) {
        cart.remove(product);
    }
    public long getQuantity(Product product) {
        return cart.get(product);
    }
    public Map<Product, Long> getCart() {
        return cart;
    }
}
