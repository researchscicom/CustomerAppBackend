package com.customer.spring.dao;

import com.customer.spring.model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAllCustomers();
    Customer getCustomer(long id);
    Long saveCustomer(Customer customer);
    void updateCustomer(Long id,Customer customer);
    void deleteCustomer(Long id);
}
