package com.clothshop.management.Product_Controller;




import com.clothshop.management.Exception.ProductNotFoundException;
import com.clothshop.management.ProductRepository.ProductRepository;
import com.clothshop.management.Product_Entity.Product;
import com.clothshop.management.Product_Service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Management", description = "Operations related to products in the cloth shop")

public class ProductController {

    private final ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Add a new product to the inventory.")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a product by ID", description = "Fetch a product using its unique ID.")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
         Product product = productRepository.findById(id)
                 .orElseThrow(()-> new ProductNotFoundException("Product with ID \" + id + \" not found\""));
        return ResponseEntity.ok(product);
    }

    @GetMapping
    @Operation(summary = "Get all products", description = "Retrieve a list of all available products.")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a product", description = "Update an existing product's details.")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Remove a product from the inventory using its ID.")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
