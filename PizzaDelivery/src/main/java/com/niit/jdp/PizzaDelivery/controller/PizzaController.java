/*
 * Author Name: Pratik Goud
 * Date: 13-12-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.PizzaDelivery.controller;

import com.niit.jdp.PizzaDelivery.domain.Pizza;
import com.niit.jdp.PizzaDelivery.exception.PizzaAlreadyExistsException;
import com.niit.jdp.PizzaDelivery.exception.PizzaDoesNotExistException;
import com.niit.jdp.PizzaDelivery.service.PizzaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin
@RestController
@RequestMapping("/api/v2")
public class PizzaController {
    private PizzaServiceImpl pizzaService;
    @Autowired
    public PizzaController(PizzaServiceImpl pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping("/insertPizza")
    public ResponseEntity<?> insertPizza (@RequestBody Pizza pizza) throws PizzaAlreadyExistsException {
        try{
            return new ResponseEntity<>(pizzaService.savePizza(pizza), HttpStatus.CREATED);
        }catch(PizzaAlreadyExistsException e){
            throw new PizzaAlreadyExistsException();
        }catch(Exception e){
            return new ResponseEntity<>("Server error, try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletePizzaById/{pizzaId}")
    public ResponseEntity<?> deletePizzaById (@PathVariable int pizzaId) throws PizzaDoesNotExistException {
        try{
            return new ResponseEntity<>(pizzaService.deletePizzaById(pizzaId), HttpStatus.OK);
        }catch(PizzaDoesNotExistException e){
            throw new PizzaDoesNotExistException();
        }catch(Exception e){
            return new ResponseEntity<>("Server error, try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchAllPizza")
    public ResponseEntity<?> fetchAllPizza (){
        return new ResponseEntity<>(pizzaService.getAllPizza(), HttpStatus.OK);
    }

    @GetMapping("/fetchPizzaById/{pizzaId}")
    public ResponseEntity<?> fetchPizzaById (@PathVariable int pizzaId) throws PizzaDoesNotExistException{
        try{
            return new ResponseEntity<>(pizzaService.getPizzaById(pizzaId), HttpStatus.OK);
        }catch(PizzaDoesNotExistException e){
            throw new PizzaDoesNotExistException();
        }catch(Exception e){
            return new ResponseEntity<>("Server error, try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchPizzaByPizzaName/{pizzaName}")
    public ResponseEntity<?> fetchPizzaByPizzaName (@PathVariable String pizzaName) throws PizzaDoesNotExistException{
        try{
            return new ResponseEntity<>(pizzaService.getPizzaByName(pizzaName), HttpStatus.OK);
        }catch(PizzaDoesNotExistException e){
            throw new PizzaDoesNotExistException();
        }catch(Exception e){
            return new ResponseEntity<>("Server error, try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
