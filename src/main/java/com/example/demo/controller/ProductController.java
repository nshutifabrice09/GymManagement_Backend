package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/product")
    public Product save(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> productList(){
        return productService.getAllProducts();
    }

    @GetMapping("/product/{productCode}")
    public Product findProductByProductCode(@PathVariable("productCode") String productCode){
        return productService.getProductByProductCode(productCode);
    }

    @DeleteMapping("/product/{productCode}")
    public void removeByProductCode(@PathVariable("productCode") String productCode){
        productService.removeByProductCode(productCode);
    }

    @PutMapping("/product/{productCode}")
    public Product updateProduct(@PathVariable("productCode") String productCode, @RequestBody Product product){
        return productService.updateProduct(productCode, product);
    }


}
