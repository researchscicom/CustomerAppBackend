package com.customer.spring.service;
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
    public Object sendMsg(Long proId) throws Exception{
        Object response = amqpTemplate.convertSendAndReceive("customer.direct","customer.routingkey",proId);
        System.out.println("============== Response ==================");
        System.out.println(response);
        System.out.println("==========================================");
        return response;
    }
}
