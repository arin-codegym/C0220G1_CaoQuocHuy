package com.rin.controllers;


import com.rin.models.Cart;
import com.rin.models.Product;
import com.rin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Set;

@Controller
@SessionAttributes("cart")

public class ProductController {
    // private Map<Product, Integer> cart = new HashMap<>();
    @Autowired
    private ProductService productService;


    @ModelAttribute("cart")
    public HashMap<Long, Object> setUpUserForm() {
        return new HashMap<>();
    }

    @GetMapping("/")
    public ModelAndView view() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/view-product/{id}")
    public ModelAndView view_information(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("information");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/view-product/{id}")
    public ModelAndView addCart(@PathVariable Long id, @ModelAttribute("cart") HashMap list) {
        Product product = productService.findById(id);
        if (product != null) {
            if (list.containsKey(id)) {



                Cart item = (Cart) list.get(id);
                ((Cart) list.get(id)).setQuantity(((Cart) list.get(id)).getQuantity()+1);
                // listCard.replace(id, new Cart(product, item.getQuantity() + 1));
            } else {
                list.put(id, new Cart(product, 1));
            }
        }
//        list.putAll(listCard);
        System.out.println(list);
        ModelAndView modelAndView = new ModelAndView("information", "product", product);
        modelAndView.addObject("message", "add ok");
        //  modelAndView.addObject("list",cart);
        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView goToCart(@ModelAttribute("cart") HashMap list) {
        double total = 0;
        Set<Long> keys = list.keySet();
        Long[] arrayKey = keys.toArray(new Long[keys.size()]);
        for (long idCart : arrayKey) {
            Cart cart = (Cart) list.get(idCart);
            System.out.println(cart.getProduct().getName());
            total= cart.getProduct().getPrice()*cart.getQuantity();

        }


        return new ModelAndView("giohang", "list", list);
    }

}
