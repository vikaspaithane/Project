package com.clothshop.management.Supplier_Service;



import com.clothshop.management.SupplierRepository.SupplierRepository;
import com.clothshop.management.Supplier_Entity.Supplier;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        Supplier existingSupplier = getSupplierById(id);
        existingSupplier.setName(supplier.getName());
        existingSupplier.setEmail(supplier.getEmail());
        existingSupplier.setPhone(supplier.getPhone());
        existingSupplier.setCompany(supplier.getCompany());
        return supplierRepository.save(existingSupplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
