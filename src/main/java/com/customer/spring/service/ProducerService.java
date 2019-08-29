package com.customer.spring.service;

import com.customer.spring.model.Customer;

public interface ProducerService {
    void sendMsg(Customer customer) throws Exception;
}
