package com.niit.jdp.RabbitMQConsumer.repository;

import com.niit.jdp.RabbitMQConsumer.domain.Pizza;
import com.niit.jdp.RabbitMQConsumer.domain.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends MongoRepository<Pizza, Integer> {

}
