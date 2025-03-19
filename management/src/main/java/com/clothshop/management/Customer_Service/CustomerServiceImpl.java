package com.clothshop.management.Customer_Service;



import com.clothshop.management.CustomerRepository.CustomerRepository;
import com.clothshop.management.Customer_Entity.Customer;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = getCustomerById(id);
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setAddress(customer.getAddress());
        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

