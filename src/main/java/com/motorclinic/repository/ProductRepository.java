package com.motorclinic.repository;

import com.motorclinic.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.idProduct = :productId")
    Product findProductById(@Param("productId") Long productId);
    @Query("SELECT p FROM Product p WHERE p.productName = :name")
    Product findProductByName (@Param("name") String name);
}
