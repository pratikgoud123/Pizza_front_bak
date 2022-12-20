/*
 * Author Name: Pratik Goud
 * Date: 13-12-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.PizzaDelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Pizza with specified details Already Exists")
public class PizzaAlreadyExistsException extends Exception{
}
