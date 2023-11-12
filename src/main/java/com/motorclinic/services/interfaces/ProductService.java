package com.motorclinic.services.interfaces;

import com.motorclinic.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
    Product getProductById(Long id);
    Product getProductByName(String name);
    List<Product> getAllProducts();
}
