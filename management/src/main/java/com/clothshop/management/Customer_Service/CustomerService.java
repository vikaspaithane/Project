package com.clothshop.management.Customer_Service;



import com.clothshop.management.Customer_Entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
}
