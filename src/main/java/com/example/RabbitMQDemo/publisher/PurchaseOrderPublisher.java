package com.example.RabbitMQDemo.publisher;

import com.example.RabbitMQDemo.resources.OrderStatus;
import com.example.RabbitMQDemo.resources.PurchaseOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public class PurchaseOrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @Value("${ust.rabbitmq.queue}")
    String queuename;

    @Value("${ust.rabbitmq.exchange}")
    String exchange;

    @Value("${ust.rabbitmq.routingkey}")
    String routingKey;

    @PostMapping("/{customerName}")
    public String bookOrder(@RequestBody PurchaseOrder order , @PathVariable String customerName)
    {
        order.setOrderId(UUID.randomUUID().toString());

        OrderStatus orderStatus=new OrderStatus(order,"ACCEPTED","Order placed successfully by "+ customerName);
        template.convertAndSend(exchange,routingKey,orderStatus);
        return "Success";
    }

}
