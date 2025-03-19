package com.clothshop.management.Supplier_Controller;



import com.clothshop.management.Exception.SupplierNotFoundException;
import com.clothshop.management.SupplierRepository.SupplierRepository;
import com.clothshop.management.Supplier_Entity.Supplier;
import com.clothshop.management.Supplier_Service.SupplierService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/suppliers")
@Tag(name = "Supplier Management", description = "Operations related to suppliers in the cloth shop")
public class SupplierController {

    private final SupplierService supplierService;
@Autowired
private SupplierRepository supplierRepository;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    @Operation(summary = "Create a new supplier", description = "Register a new supplier by providing their details.")
    public ResponseEntity<Supplier> addSupplier(@Valid @RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.addSupplier(supplier));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a supplier by ID", description = "Fetch supplier details using their unique ID.")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(()-> new SupplierNotFoundException("Supplier with ID " + id + " not found"));
        return ResponseEntity.ok(supplierService.getSupplierById(id));
    }

    @GetMapping
    @Operation(summary = "Get all suppliers", description = "Retrieve a list of all registered suppliers.")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a supplier", description = "Update an existing supplier's information.")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.updateSupplier(id, supplier));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a supplier", description = "Remove a supplier from the database using their ID.")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok("Supplier deleted successfully");
    }
}
