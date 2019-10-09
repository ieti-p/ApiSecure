package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.entities.User;
import com.eci.cosw.springbootsecureapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.List;
import javax.servlet.ServletException;
import java.util.Date;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@RestController
@RequestMapping( "user" )
public class UserController
{

    @Autowired
    private UserService userService;

//    @Autowired
    //UserService userService;



    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login )
        throws ServletException
    {

        String jwtToken = "";

        if ( login.getUsername() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String username = login.getUsername();
        String password = login.getPassword();

        //TODO implement logic to verify user credentials
        User user = userService.getUser( 0l );

        if ( user == null )
        {
            throw new ServletException( "User username not found." );
        }

        String pwd = user.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }
        //
        jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
            SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    public class Token
    {

        String accessToken;


        public Token( String accessToken )
        {
            this.accessToken = accessToken;
        }


        public String getAccessToken()
        {
            return accessToken;
        }

        public void setAccessToken( String access_token )
        {
            this.accessToken = access_token;
        }
    }
    @GetMapping(value = "/v1/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping(value = "/v1/user/login")
    public ResponseEntity< String> getUserlOg() {
        //List<User> users = userService.getUsers();
        return new ResponseEntity<>("", HttpStatus.OK);
    }    
    

    @GetMapping(value = "/v1/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User user = userService.getUserById(Integer.parseInt(userId));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/v1/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userCreated = userService.addUser(user);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }

    @PutMapping(value = "/v1/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User userUpdated = userService.updateUser(user);
        return new ResponseEntity<>(userUpdated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/v1/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        User u= userService.deleteUser(Integer.parseInt(userId));
        return new ResponseEntity<>("Removed user: "+u, HttpStatus.OK);
    }



}
