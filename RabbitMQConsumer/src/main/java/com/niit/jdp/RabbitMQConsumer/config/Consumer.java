package com.niit.jdp.RabbitMQConsumer.config;

import com.niit.jdp.RabbitMQConsumer.domain.Pizza;
import com.niit.jdp.RabbitMQConsumer.service.PizzaServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private PizzaServiceImpl pizzaService;

    @RabbitListener(queues = "pizzaqueue")
    public void getData(PizzaDTO pizzaDTO)
    {
        Pizza pizza = new Pizza();

        pizza.setPizzaId(pizzaDTO.getPizzaId());
        pizza.setPizzaName(pizzaDTO.getPizzaName());
        pizza.setPizzaSize(pizzaDTO.getPizzaSize());
        pizza.setPizzaCategory(pizzaDTO.getPizzaCategory());

        pizzaService.savePizza(pizza);

    }
}
