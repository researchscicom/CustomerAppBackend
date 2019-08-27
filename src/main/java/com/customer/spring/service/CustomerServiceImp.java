package com.customer.spring.service;

import com.customer.spring.dao.CustomerDAO;
import com.customer.spring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    public Customer getCustomer(long id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    public Long saveCustomer(Customer customer) {
        return customerDAO.saveCustomer(customer);
    }

    @Transactional
    @Override
    public void updateCustomer(Long id, Customer customer) {
        customerDAO.updateCustomer(id,customer);
    }

    @Transactional
    @Override
    public void deleteCustomer(Long id) {
        customerDAO.deleteCustomer(id);
    }
}
