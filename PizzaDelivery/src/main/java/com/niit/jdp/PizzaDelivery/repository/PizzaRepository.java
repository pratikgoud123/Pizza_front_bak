package com.niit.jdp.PizzaDelivery.repository;

import com.niit.jdp.PizzaDelivery.domain.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends MongoRepository<Pizza, Integer> {

    List<Pizza> findByPizzaName (String pizzaName);
}
