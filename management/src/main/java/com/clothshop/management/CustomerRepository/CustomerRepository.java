package com.clothshop.management.CustomerRepository;



import com.clothshop.management.Customer_Entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Example: Find customer by email
    Customer findByEmail(String email);
}
