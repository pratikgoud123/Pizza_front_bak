/*
 * Author Name: Pratik Goud
 * Date: 29-11-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.UserAuthenticationService.controller;

import com.niit.jdp.UserAuthenticationService.domain.User;
import com.niit.jdp.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.niit.jdp.UserAuthenticationService.exception.UserNotFoundException;
import com.niit.jdp.UserAuthenticationService.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserServiceImpl userService;
    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<?> insertUser (@RequestBody User user) throws UserAlreadyExistsException {
        try{
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
        }catch(UserAlreadyExistsException e){
            throw new UserAlreadyExistsException();
        }catch(Exception e){
            return new ResponseEntity<>("Server error, try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/fetchAllUsers")
    public ResponseEntity<?> fetchAllUsers (){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity<?> loginUser (@PathVariable String username, @PathVariable String password) throws UserNotFoundException {
        try{
            return new ResponseEntity<>(userService.loginCheck(username, password), HttpStatus.OK);
        }catch(UserNotFoundException ue){
            throw new UserNotFoundException();
        }catch(Exception e){
            return new ResponseEntity<>("Network Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchByUsername/{username}")
    public ResponseEntity<?> fetchByUsername (@PathVariable String username) throws UserNotFoundException{
        try{
            return new ResponseEntity<>(userService.getByUserName(username), HttpStatus.OK);
        }catch(UserNotFoundException ue){
            throw new UserNotFoundException();
        }catch(Exception e){
            return new ResponseEntity<>("Network Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteByUsername/{username}")
    public ResponseEntity<?> deleteByUsername (@PathVariable String username){
        userService.deleteUserByUsername(username);
        return new ResponseEntity<>("user record has been deleted", HttpStatus.OK);
    }

    @GetMapping("/fetchByUserId/{userId}")
    public ResponseEntity<?> fetchByUserId (@PathVariable int userId){
        return new ResponseEntity<>(userService.getByUserId(userId), HttpStatus.OK);
    }
}