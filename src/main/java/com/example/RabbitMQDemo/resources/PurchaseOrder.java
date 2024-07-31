package com.example.RabbitMQDemo.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {

    private String orderId;
    private String company;
    private int qty;
    private double price;
}
