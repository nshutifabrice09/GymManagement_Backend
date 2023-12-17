package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.Trainer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo  extends JpaRepository<Product, Long> {

    Product findByProductCode(String productCode);


    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.productCode = :productCode")
    void removeProductCode(@Param("productCode")String productCode);

}
