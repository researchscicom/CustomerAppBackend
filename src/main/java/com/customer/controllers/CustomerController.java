package com.customer.controllers;

import com.customer.models.Customer;
import com.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value="/getcustomers",method = RequestMethod.GET)
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
}
