package com.niit.jdp.RabbitMQConsumer.service;

import com.niit.jdp.RabbitMQConsumer.domain.Pizza;
import com.niit.jdp.RabbitMQConsumer.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaServiceImpl implements IPizzaService{

    private PizzaRepository pizzaRepository;

    @Autowired
    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public Pizza savePizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }
}
