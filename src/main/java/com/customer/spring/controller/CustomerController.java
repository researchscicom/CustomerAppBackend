package com.customer.spring.controller;
import com.customer.spring.model.Customer;
import com.customer.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getCustomers()
    {
        List<Customer> customers=customerService.getAllCustomers();
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id)
    {
        Customer customer=customerService.getCustomer(id);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customer")
    public void save(@RequestBody Customer customer)
    {
        customerService.saveCustomer(customer);
    }

    @PutMapping("/customer/{id}")
    public void editCustomer(@PathVariable("id") long id,@RequestBody Customer customer)
    {
        System.out.println(customer.toString());
        customerService.updateCustomer(id,customer);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable("id") long id)
    {
        customerService.deleteCustomer(id);
    }
}