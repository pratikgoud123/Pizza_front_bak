/*
 * Author Name: Pratik Goud
 * Date: 29-11-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.UserAuthenticationService.service;

import com.niit.jdp.UserAuthenticationService.domain.User;
import com.niit.jdp.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.niit.jdp.UserAuthenticationService.exception.UserNotFoundException;
import com.niit.jdp.UserAuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if (userRepository.findById(user.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User loginCheck(String username, String password) throws UserNotFoundException {
        User userObj = userRepository.findByUsernameAndPassword(username, password);
        if (userObj == null){
            throw new UserNotFoundException();
        }
        return userObj;
    }

    @Override
    public Optional<User> getByUserName(String username) throws UserNotFoundException {
        if (username == null){
            throw new UserNotFoundException();
        }
        return userRepository.findById(username);
    }

    @Override
    public boolean deleteUserByUsername(String username) {
        userRepository.deleteById(username);
        return true;
    }

    @Override
    public Optional<User> getByUserId(int userId)  {
        return Optional.ofNullable(userRepository.findByUserId(userId));
    }
}
