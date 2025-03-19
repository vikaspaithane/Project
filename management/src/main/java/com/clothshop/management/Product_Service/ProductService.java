package com.clothshop.management.Product_Service;



import com.clothshop.management.Product_Entity.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
