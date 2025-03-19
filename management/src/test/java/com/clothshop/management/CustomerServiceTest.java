package com.clothshop.management;


import com.clothshop.management.CustomerRepository.CustomerRepository;
import com.clothshop.management.Customer_Entity.Customer;
import com.clothshop.management.Customer_Service.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customer = new Customer("Rajesh Kumar", "rajesh@example.com", "9876543210", "Mumbai");
    }

    @Test
    void testAddCustomer() {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer savedCustomer = customerService.addCustomer(customer);

        assertNotNull(savedCustomer);
        assertEquals("Rajesh Kumar", savedCustomer.getName());
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void testGetCustomerById() {
        when(customerRepository.findById(1L)).thenReturn(java.util.Optional.of(customer));

        Customer foundCustomer = customerService.getCustomerById(1L);

        assertNotNull(foundCustomer);
        assertEquals("Rajesh Kumar", foundCustomer.getName());
    }

    @Test
    void testDeleteCustomer() {
        doNothing().when(customerRepository).deleteById(1L);

        customerService.deleteCustomer(1L);

        verify(customerRepository, times(1)).deleteById(1L);
    }
}

