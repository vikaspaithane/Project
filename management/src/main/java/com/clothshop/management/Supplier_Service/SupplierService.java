package com.clothshop.management.Supplier_Service;



import com.clothshop.management.Supplier_Entity.Supplier;

import java.util.List;

public interface SupplierService {
    Supplier addSupplier(Supplier supplier);
    Supplier getSupplierById(Long id);
    List<Supplier> getAllSuppliers();
    Supplier updateSupplier(Long id, Supplier supplier);
    void deleteSupplier(Long id);
}
