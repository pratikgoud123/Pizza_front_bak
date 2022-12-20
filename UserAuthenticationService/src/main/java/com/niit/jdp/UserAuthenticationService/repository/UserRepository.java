package com.niit.jdp.UserAuthenticationService.repository;

import com.niit.jdp.UserAuthenticationService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public User findByUsernameAndPassword (String username, String password);  //this method will be used for login functionality

    public User findByUserId (int userId);

}
