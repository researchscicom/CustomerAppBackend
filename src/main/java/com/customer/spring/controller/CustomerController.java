package com.customer.spring.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {

    @GetMapping("/customers")
    public String getAllDetails()
    {
        return "Hey";
    }
}
