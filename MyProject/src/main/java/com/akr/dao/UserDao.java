package com.akr.dao;

import java.util.List;

import com.akr.model.User;


public interface UserDao {

	User findByUserName(String username);
	
	void addUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(User user);
	
	List<User> findAllUsers();

}