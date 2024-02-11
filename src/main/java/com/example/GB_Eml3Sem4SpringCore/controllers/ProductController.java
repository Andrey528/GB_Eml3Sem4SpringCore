package com.example.GB_Eml3Sem4SpringCore.controllers;

import com.example.GB_Eml3Sem4SpringCore.models.Product;
import com.example.GB_Eml3Sem4SpringCore.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product p, Model model) {
        productService.addProduct(p);
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }
}
