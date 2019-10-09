package com.eci.cosw.springbootsecureapi.service;



import java.util.List;

import com.eci.cosw.springbootsecureapi.entities.User;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public interface UserService
{
    List<User> getUsers();

    User getUser( long i );

    User createUser( User user );

    User findUserByEmail( String email );

    User findUserByEmailAndPassword(String email, String password );
   
    User getUserById(int userId);
	
    User getUserByUsername(String username);
	
    User addUser(User user);
	
    User updateUser(User user);
	
    User deleteUser(int userId);
	

}
