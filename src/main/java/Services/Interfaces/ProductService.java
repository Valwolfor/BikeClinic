package Services.Interfaces;

import Beans.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Integer id);
    Product getProductById(Integer id);
    Product getProductByName(String name);
    List<Product> getAllProducts();
}
