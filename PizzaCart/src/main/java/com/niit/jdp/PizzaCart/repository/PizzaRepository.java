package com.niit.jdp.PizzaCart.repository;

import com.niit.jdp.PizzaCart.domain.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends MongoRepository<Pizza, Integer> {

    List<Pizza> findByPizzaName (String pizzaName);
}

