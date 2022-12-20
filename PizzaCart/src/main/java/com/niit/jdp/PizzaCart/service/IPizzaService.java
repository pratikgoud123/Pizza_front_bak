package com.niit.jdp.PizzaCart.service;

import com.niit.jdp.PizzaCart.domain.Pizza;

import java.util.List;
import java.util.Optional;

public interface IPizzaService {

    Pizza savePizza (Pizza pizza);
    boolean deletePizzaById (int pizzaId);
    List<Pizza> getAllPizza ();
    boolean deleteAllPizza ();
    Optional<Pizza> getPizzaById (int customerId);

    List<Pizza> getPizzaByName (String productName);

}