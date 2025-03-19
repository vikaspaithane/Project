package com.clothshop.management.SupplierRepository;

import com.clothshop.management.Supplier_Entity.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    // Example: Find supplier by name
    Supplier findByName(String name);
}
