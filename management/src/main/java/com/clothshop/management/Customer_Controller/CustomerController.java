package com.clothshop.management.Customer_Controller;



import com.clothshop.management.CustomerRepository.CustomerRepository;
import com.clothshop.management.Customer_Entity.Customer;
import com.clothshop.management.Customer_Service.CustomerService;

import com.clothshop.management.Exception.CustomerNotFoundException;
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
@RequestMapping("/api/customers")
@Tag(name = "Customer Management", description = "Operations related to customers")
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @Operation(summary = "Create a new customer", description = "Register a new customer by providing their details.")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a customer by ID", description = "Fetch a single customer using their unique ID.")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found"));
        return ResponseEntity.ok(customer);
    }
    @GetMapping
    @Operation(summary = "Get all customers", description = "Retrieve a list of all registered customers.")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a customer", description = "Update an existing customer's information.")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a customer", description = "Remove a customer from the database using their ID.")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
