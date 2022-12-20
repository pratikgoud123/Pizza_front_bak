package com.niit.jdp.PizzaDelivery.service;

import com.niit.jdp.PizzaDelivery.domain.Pizza;
import com.niit.jdp.PizzaDelivery.exception.PizzaAlreadyExistsException;
import com.niit.jdp.PizzaDelivery.exception.PizzaDoesNotExistException;

import java.util.List;
import java.util.Optional;

public interface IPizzaService {

    Pizza savePizza (Pizza pizza) throws PizzaAlreadyExistsException;
    boolean deletePizzaById (int pizzaId) throws PizzaDoesNotExistException;
    List<Pizza> getAllPizza ();
    Optional<Pizza> getPizzaById (int customerId) throws PizzaDoesNotExistException;

    List<Pizza> getPizzaByName (String productName) throws PizzaDoesNotExistException;

}
