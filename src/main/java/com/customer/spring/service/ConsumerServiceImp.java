package com.customer.spring.service;

import com.customer.spring.dao.CustomerDAO;
import com.customer.spring.model.Customer;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImp implements ConsumerService {
    private static final String EXCHANGE_NAME = "product.direct";
    @Autowired
    CustomerDAO customerDAO;

    @Override
//    @RabbitListener(
//            bindings = @QueueBinding(
//                    value = @Queue(value = "product.queue",durable = "true"),
//                    exchange = @Exchange(value = EXCHANGE_NAME),
//                    key = "product.routingkey")
//    )
    public Customer consumerMessage(Object data) {
        System.out.println(" Product sent  " + data );
        return customerDAO.getCustomer(5);
    }
}
