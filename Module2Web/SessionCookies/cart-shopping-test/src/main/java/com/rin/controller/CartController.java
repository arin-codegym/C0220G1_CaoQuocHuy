package com.rin.controller;


import com.rin.models.Cart;
import com.rin.models.Product;
import com.rin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setUpUserForm() {
        return new Cart();
    }

    @GetMapping("/")
    public ModelAndView showProductList() {
        return new ModelAndView("list", "products", productService.findAll());
    }

    @GetMapping("/view-product/{id}")
    public ModelAndView viewProduct(@PathVariable("id") Long id) {
        System.out.println(productService.findById(id).getProductId());
        return new ModelAndView("view", "product", productService.findById(id));
    }

    @PostMapping("/buy/{id}")
    public ModelAndView addViewProduct(@PathVariable("id") Long id, @ModelAttribute("cart") Cart cart, @RequestParam(value = "quantity", required = false) Integer valueProduct) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("product", product);
        if (product == null) {
            modelAndView.addObject("message", "Error");
        } else {
                cart.addToCart(product,valueProduct);
                modelAndView.addObject("message", "Add " + product.getProductName() + " to cart successfully\nAmount: " + cart.getQuantity(product));
            }
//        System.out.println("test");
//        System.out.println(cart.getCart().toString());
        return modelAndView;
    }


    @GetMapping("/cart")
    public ModelAndView goToCart(@ModelAttribute("cart") Cart cart) {
        return new ModelAndView("show", "list", cart.getCart());
    }

    @GetMapping("/cart/{id}")
    public ModelAndView removeProduct(@ModelAttribute("cart") Cart cart, @PathVariable("id") Long id) {
        cart.removeProduct(productService.findById(id));
        return new ModelAndView("redirect:/cart");
    }
}

