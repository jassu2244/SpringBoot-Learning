package com.telusko.SpringEcom.controller;

import com.telusko.SpringEcom.model.Product;
import com.telusko.SpringEcom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api") //is used to map an HTTP request (URL) to a controller method or an entire controller class.
@CrossOrigin //resolved frontend cors error
public class ProductController {

    @Autowired //"Find an object (bean) of this type and inject it here automatically."
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

}
