package com.customer.spring.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@PropertySource("classpath:db.properties")
@Service
public class ProduceServiceImp implements ProducerService {
    private static final String EXCHANGE_NAME = "messages";

    private AmqpTemplate amqpTemplate;

    @Value("jsa.rabbitmq.exchange")
    private String exchange;

    @Value("jsa.rabbitmq.routingkey")
    private String routingkey;

    @Override
    public void produceData(String msg) {
        try{
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setUsername("guest");
            factory.setPassword("guest");
            factory.setPort(15672);
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME,"jpa.direct");
            channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());
            System.out.println("[x] sent '"+msg+"'");
            channel.close();
            connection.close();

        }catch(IOException e){
            System.out.println("IOException");
            e.printStackTrace();
        }catch(TimeoutException te){
            System.out.println("TimeOut Exception");
            te.printStackTrace();
        }

//        amqpTemplate.convertAndSend(exchange,routingkey,msg);
    }
}
