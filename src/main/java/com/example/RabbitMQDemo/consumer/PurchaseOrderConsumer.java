package com.example.RabbitMQDemo.consumer;

import com.example.RabbitMQDemo.resources.OrderStatus;
import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

public class PurchaseOrderConsumer {

    Logger logger = Logger.getLogger("Hi");
    @Value("${ust.rabbitmq.queue}")
    String queuename;

    @Value("${ust.rabbitmq.exchange}")
    String exchange;

    @Value("${ust.rabbitmq.routingkey}")
    String routingKey;

    @RabbitListener(queues = "ust_queue")
    public void consumeMessageFromQueue(OrderStatus orderStatus)
    {
       logger.info("Message received from queue : "+ orderStatus) ;
    }
}
