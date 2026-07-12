package com.telusko.SpringEcom.controller;

import com.telusko.SpringEcom.model.Product;
import com.telusko.SpringEcom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api") //is used to map an HTTP request (URL) to a controller method or an entire controller class.
@CrossOrigin //resolved frontend cors error
public class ProductController {

    @Autowired //"Find an object (bean) of this type and inject it here automatically."
    private ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED); //this is used to send custom http status
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);

        if(product.getId() > 0)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int productId) {
        Product product = productService.getProductById(productId); //this gives entire product I want just one thing

        if(product.getId() > 0)
            return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?>  addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product savedProduct = null;
        try {
            savedProduct = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
