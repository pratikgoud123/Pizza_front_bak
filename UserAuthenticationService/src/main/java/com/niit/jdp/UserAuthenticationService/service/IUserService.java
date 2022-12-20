package com.niit.jdp.UserAuthenticationService.service;

import com.niit.jdp.UserAuthenticationService.domain.User;
import com.niit.jdp.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.niit.jdp.UserAuthenticationService.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public User saveUser(User user) throws UserAlreadyExistsException;
    public List<User> getAllUsers();
    public User loginCheck(String username, String password) throws UserNotFoundException;
    public Optional<User> getByUserName(String username) throws UserNotFoundException;
    public boolean deleteUserByUsername (String username);
    public Optional<User> getByUserId(int userId);

}
