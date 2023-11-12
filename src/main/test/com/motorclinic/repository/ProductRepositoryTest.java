package com.motorclinic.repository;

import com.motorclinic.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    @Rollback
    public void testSaveProduct() {
        // Arrange
        Product product = new Product();
        product.setProductName("Oil Change");
        product.setProductValue(BigDecimal.valueOf(50.0));
        product.setQuantity(10);

        // Act
        Product savedProduct = productRepository.save(product);

        // Assert
        Assertions.assertNotNull(savedProduct.getIdProduct());
        Assertions.assertEquals("Oil Change", savedProduct.getProductName());
        Assertions.assertEquals(BigDecimal.valueOf(50.0), savedProduct.getProductValue());
        Assertions.assertEquals(10, savedProduct.getQuantity());
    }

    @Test
    @Transactional
    @Rollback
    public void testFindProductById() {
        // Arrange
        Product product = new Product();
        product.setProductName("Brake Pads");
        product.setProductValue(BigDecimal.valueOf(30.0));
        product.setQuantity(5);
        Product savedProduct = productRepository.save(product);

        // Act
        Product foundProduct = productRepository.findProductById(savedProduct.getIdProduct());

        // Assert
        Assertions.assertNotNull(foundProduct);
        Assertions.assertEquals("Brake Pads", foundProduct.getProductName());
        Assertions.assertEquals(BigDecimal.valueOf(30.0), foundProduct.getProductValue());
        Assertions.assertEquals(5, foundProduct.getQuantity());
    }

    @Test
    @Transactional
    @Rollback
    public void testFindProductByName() {
        // Arrange
        Product product = new Product();
        product.setProductName("Spark Plugs");
        product.setProductValue(BigDecimal.valueOf(10.0));
        product.setQuantity(20);
        Product savedProduct = productRepository.save(product);

        // Act
        Product foundProduct = productRepository.findProductByName("Spark Plugs");

        // Assert
        Assertions.assertNotNull(foundProduct);
        Assertions.assertEquals("Spark Plugs", foundProduct.getProductName());
        Assertions.assertEquals(BigDecimal.valueOf(10.0), foundProduct.getProductValue());
        Assertions.assertEquals(20, foundProduct.getQuantity());
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdateProduct() {
        // Arrange
        Product product = new Product();
        product.setProductName("Air Filter");
        product.setProductValue(BigDecimal.valueOf(15.0));
        product.setQuantity(8);
        Product savedProduct = productRepository.save(product);

        // Act
        savedProduct.setProductValue(BigDecimal.valueOf(20.0));
        Product updatedProduct = productRepository.save(savedProduct);

        // Assert
        Assertions.assertEquals(savedProduct.getIdProduct(), updatedProduct.getIdProduct());
        Assertions.assertEquals(BigDecimal.valueOf(20.0), updatedProduct.getProductValue());
        Assertions.assertEquals(8, updatedProduct.getQuantity());
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteProduct() {
        // Arrange
        Product product = new Product();
        product.setProductName("Battery");
        product.setProductValue(BigDecimal.valueOf(70.0));
        product.setQuantity(3);
        Product savedProduct = productRepository.save(product);

        // Act
        productRepository.delete(savedProduct);

        // Assert
        Assertions.assertFalse(productRepository.existsById(savedProduct.getIdProduct()));
    }
}

