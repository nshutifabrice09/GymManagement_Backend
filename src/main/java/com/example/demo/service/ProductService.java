package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductByProductCode(String productCode);

    Product saveProduct(Product product);

    Product updateProduct(String productCode, Product product);

    void removeByProductCode(String productCode);

}
