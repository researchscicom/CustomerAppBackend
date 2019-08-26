package com.customer.spring.service;

import com.rabbitmq.client.*;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@PropertySource("classpath:db.properties")
@Service
public class ProduceServiceImp implements ProducerService {
    private static final String EXCHANGE_NAME = "jsa.direct";
    private static final String QUEUE_NAME = "jsa.queue";

    private RabbitTemplate amqpTemplate;

    @Override
    public void produceData(String msg) {
//        try{
//            ConnectionFactory factory = new ConnectionFactory();
//            factory.setHost("localhost");
//            factory.setVirtualHost("guest");
//            factory.setUsername("guest");
//            factory.setPassword("guest");
//            factory.setPort(5672);
//            Connection connection = factory.newConnection();
//            Channel channel = connection.createChannel();
//
//            channel.exchangeDeclare(EXCHANGE_NAME,BuiltinExchangeType.DIRECT);
//            channel.basicPublish(EXCHANGE_NAME,"jsa.routingkey",null,msg.getBytes());
//            System.out.println("[x] sent '"+msg+"'");
//            channel.close();
//            connection.close();
//
//        }catch(IOException e){
//            System.out.println("IOException");
//            e.printStackTrace();
//        }catch(TimeoutException te){
//            System.out.println("TimeOut Exception");
//            te.printStackTrace();
//        }
        //amqpTemplate.convertAndSend("jsa.direct","jsa.routingkey",msg);
    }
}