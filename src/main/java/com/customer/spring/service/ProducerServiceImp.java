package com.customer.spring.service;

import com.customer.spring.model.Customer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class ProducerServiceImp implements ProducerService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMsg(Customer customer) throws Exception{
//        amqpTemplate.convertAndSend("customer.direct","customer.routingkey",customer);
        Object response = (Object) amqpTemplate.convertSendAndReceive("customer.direct","customer.routingkey",customer);
        System.out.println("===============Response ==================");
        System.out.println(response);
        System.out.println("==========================================");

    }
}
