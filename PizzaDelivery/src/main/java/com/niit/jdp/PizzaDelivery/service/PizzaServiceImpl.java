/*
 * Author Name: Pratik Goud
 * Date: 13-12-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.PizzaDelivery.service;

import com.niit.jdp.PizzaDelivery.config.PizzaDTO;
import com.niit.jdp.PizzaDelivery.config.Producer;
import com.niit.jdp.PizzaDelivery.domain.Pizza;
import com.niit.jdp.PizzaDelivery.exception.PizzaAlreadyExistsException;
import com.niit.jdp.PizzaDelivery.exception.PizzaDoesNotExistException;
import com.niit.jdp.PizzaDelivery.repository.PizzaRepository;
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

    @Autowired
    Producer producer;

    @Override
    public Pizza savePizza(Pizza pizza) throws PizzaAlreadyExistsException {
        if (pizzaRepository.findById(pizza.getPizzaId()).isPresent()){
            throw new PizzaAlreadyExistsException();
        }
        return pizzaRepository.save(pizza);
    }

    @Override
    public boolean deletePizzaById (int pizzaId) throws PizzaDoesNotExistException {
        if (pizzaRepository.findById(pizzaId).isEmpty()){
            throw new PizzaDoesNotExistException();
        }
        pizzaRepository.deleteById(pizzaId);
        return true;
    }

    @Override
    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }

    @Override
    public Optional<Pizza> getPizzaById(int pizzaId) throws PizzaDoesNotExistException {
        if (pizzaRepository.findById(pizzaId).isEmpty()){
            throw new PizzaDoesNotExistException();
        }
        Optional<Pizza> pizzaById = pizzaRepository.findById(pizzaId);

        try {
            System.out.println(" user data fetched from client request---" + pizzaById.get().toString());

            PizzaDTO pizzaDTO = new PizzaDTO();

            pizzaDTO.setPizzaId(pizzaById.get().getPizzaId());
            pizzaDTO.setPizzaName(pizzaById.get().getPizzaName());
            pizzaDTO.setPizzaSize(pizzaById.get().getPizzaSize());
            pizzaDTO.setPizzaCategory(pizzaById.get().getPizzaCategory());

            producer.sendmsg(pizzaDTO);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getStackTrace());
        }
        return pizzaRepository.findById(pizzaId);
    }

    @Override
    public List<Pizza> getPizzaByName(String pizzaName) throws PizzaDoesNotExistException {
        if (pizzaRepository.findByPizzaName(pizzaName).isEmpty()) {
            throw new PizzaDoesNotExistException();
        }
        return pizzaRepository.findByPizzaName(pizzaName);
    }
}
