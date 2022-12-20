package com.niit.jdp.PizzaCart.controller;

import com.niit.jdp.PizzaCart.domain.Pizza;
import com.niit.jdp.PizzaCart.service.PizzaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
public class PizzaController {

    private PizzaServiceImpl pizzaService;
    @Autowired
    public PizzaController(PizzaServiceImpl pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping("/insertPizza")
    public ResponseEntity<?> insertPizza (@RequestBody Pizza pizza) {

        return new ResponseEntity<>(pizzaService.savePizza(pizza), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePizzaById/{pizzaId}")
    public ResponseEntity<?> deletePizzaById (@PathVariable int pizzaId) {

        return new ResponseEntity<>(pizzaService.deletePizzaById(pizzaId), HttpStatus.OK);

    }

    @GetMapping("/fetchAllPizza")
    public ResponseEntity<?> fetchAllPizza (){
        return new ResponseEntity<>(pizzaService.getAllPizza(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllPizza")
    public ResponseEntity<?> deleteAllPizza (){
        return new ResponseEntity<>(pizzaService.deleteAllPizza(), HttpStatus.OK);
    }

}
