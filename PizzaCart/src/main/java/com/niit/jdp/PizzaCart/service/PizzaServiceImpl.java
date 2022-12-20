package com.niit.jdp.PizzaCart.service;

import com.niit.jdp.PizzaCart.domain.Pizza;
import com.niit.jdp.PizzaCart.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean deletePizzaById(int pizzaId) {
        pizzaRepository.deleteById(pizzaId);
        return true;
    }

    @Override
    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }

    @Override
    public boolean deleteAllPizza() {
        pizzaRepository.deleteAll();
        return true;
    }

    @Override
    public Optional<Pizza> getPizzaById(int customerId) {
        return Optional.empty();
    }

    @Override
    public List<Pizza> getPizzaByName(String productName) {
        return null;
    }
}
