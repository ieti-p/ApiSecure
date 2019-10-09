package com.eci.cosw.springbootsecureapi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eci.cosw.springbootsecureapi.entities.User;
import  com.eci.cosw.springbootsecureapi.service.UserService;

public class UserServiceImpl implements UserService{

	private Map<Integer, User> users = new HashMap<>();
		
	
	@Override
	public List<User> getUsers() {
		List<User> list = new ArrayList<>();
        for (int id : users.keySet()) {
            list.add(users.get(id));
        }
        return list;
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


	@Override
	public User getUser(long i) {
		// TODO Auto-generated method stub
		return null;
	}








}
