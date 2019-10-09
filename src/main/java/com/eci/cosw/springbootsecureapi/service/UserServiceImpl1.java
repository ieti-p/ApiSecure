package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl1
    implements UserService
{

    private List<User> users = new ArrayList<>();


    @Autowired
    public UserServiceImpl1()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( 0, null, "test@mail.com", "password", "Andres", "Perez" ) );
    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    //@Override
    public User getUser( Long id )
    {
        User temp=new User();
        for(User us: users){
            if(us.getId()==id){
                temp=us;
            }        
        }

        return temp;
    }
/**
    @Override
    public User createUser1( User user )
    {
        User temp=new User(user.getEmail(), user.getPassword(), user.getFirstname(), user.getLastname());
        return temp;
    }

    @Override
    public User findUserByEmail( String email )
   {
        User temp=new User();
        for(User us: users){
            if(us.getEmail().equals(email)){
                temp=us;
            }        
        }

        return temp;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password )
    {
        User temp=new User();
        for(User us: users){
            if(us.getEmail().equals(email) && us.getPassword().equals(password)){
                temp=us;
            }        
        }

        return temp;
    }

	@Override
	public com.eci.cosw.springbootsecureapi.entities.User getUser(long i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.eci.cosw.springbootsecureapi.entities.User createUser(
			com.eci.cosw.springbootsecureapi.entities.User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.eci.cosw.springbootsecureapi.entities.User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.eci.cosw.springbootsecureapi.entities.User findUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.eci.cosw.springbootsecureapi.entities.User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.eci.cosw.springbootsecureapi.entities.User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.eci.cosw.springbootsecureapi.entities.User addUser(com.eci.cosw.springbootsecureapi.entities.User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.eci.cosw.springbootsecureapi.entities.User updateUser(
			com.eci.cosw.springbootsecureapi.entities.User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.eci.cosw.springbootsecureapi.entities.User deleteUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public User getUser(long i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
