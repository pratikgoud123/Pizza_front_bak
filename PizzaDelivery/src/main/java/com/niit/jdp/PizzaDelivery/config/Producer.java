package com.niit.jdp.PizzaDelivery.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;

    public Producer(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    public void sendmsg (PizzaDTO pizzaDTO) {
        rabbitTemplate.convertAndSend(directExchange.getName(),"pizzaroutingkey", pizzaDTO);
    }
}
