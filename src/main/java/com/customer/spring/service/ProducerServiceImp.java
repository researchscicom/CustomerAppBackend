package com.customer.spring.service;

import com.customer.spring.model.Customer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
@Transactional(readOnly = true)
public class ProducerServiceImp implements ProducerService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMsg(Customer customer) {
        amqpTemplate.convertAndSend("customer.direct","customer.routingkey",customer);
    }
}
