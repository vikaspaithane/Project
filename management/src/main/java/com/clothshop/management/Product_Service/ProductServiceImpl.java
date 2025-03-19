package com.clothshop.management.Product_Service;



import com.clothshop.management.ProductRepository.ProductRepository;
import com.clothshop.management.Product_Entity.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository  productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStockQuantity(product.getStockQuantity());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
