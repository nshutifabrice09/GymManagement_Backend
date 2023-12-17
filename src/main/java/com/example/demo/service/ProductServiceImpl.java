package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductByProductCode(String productCode) {
        return productRepo.findByProductCode(productCode);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(String productCode, Product product) {
        Product existProduct = productRepo.findByProductCode(productCode);
        if(existProduct != null){
            existProduct.setProductCode(product.getProductCode());
            existProduct.setProduct_name(product.getProduct_name());
            existProduct.setPrice(product.getPrice());
            existProduct.setStatus(product.getStatus());
        }return null;
    }

    @Override
    public void removeByProductCode(String productCode) {
        productRepo.removeProductCode(productCode);
    }
}
