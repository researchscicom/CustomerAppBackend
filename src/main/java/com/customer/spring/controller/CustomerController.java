package com.customer.spring.controller;

import com.customer.spring.model.Customer;
import com.customer.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllDetails() throws NullPointerException
    {
        return customerService.getCustomers();
    }
}
