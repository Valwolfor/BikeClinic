//package com.motorclinic.services.implementations;
//
//import com.motorclinic.entity.Product;
//import com.motorclinic.repository.ProductRepository;
//import com.motorclinic.services.interfaces.ProductService;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class ProductServiceImpl implements ProductService {
//
//    private final ProductRepository repository;
//
//    public ProductServiceImpl(ProductRepository repository) {
//        this.repository = repository;
//    }
//    @Override
//    public Product createProduct(Product product) {
//        return repository.save(product);
//    }
//
//    @Override
//    public Product updateProduct(Product product) {
//        Product oldProduct = repository.findById(product.getIdProduct()).orElse(null);
//        if (oldProduct != null) {
//            oldProduct.setProductName(product.getProductName());
//            oldProduct.setProductValue(product.getProductValue());
//        }
//
//        if (oldProduct == null) {
//            throw new EntityNotFoundException("Registro de producto no encontrado con ID: " + product.getIdProduct());
//        }
//        return repository.save(oldProduct);
//    }
//
//    @Override
//    public void deleteProduct(Integer id) {
//        repository.deleteById(id);
//    }
//
//    @Override
//    public Product getProductById(Integer id) {
//        return repository.findProductById(id);
//    }
//
//    @Override
//    public Product getProductByName(String name) {
//        return repository.findProductByName(name);
//    }
//
//    @Override
//    public List<Product> getAllProducts() {
//        return repository.findAll();
//    }
//}
