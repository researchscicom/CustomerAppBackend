package com.customer.spring.service;

import com.customer.spring.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomer(long id);
    Long saveCustomer(Customer customer);
    void updateCustomer(Long id,Customer customer);
    void deleteCustomer(Long id);
}
