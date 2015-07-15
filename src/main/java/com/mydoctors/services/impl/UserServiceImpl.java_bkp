package com.mydoctors.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydoctors.dao.UserDAO;
import com.mydoctors.domain.User;
import com.mydoctors.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	public void saveUser(User user) {
		// TODO Auto-generated method stub

	}

	public void updateUser() {
		// TODO Auto-generated method stub

	}

	public void deleteUser() {
		// TODO Auto-generated method stub

	}

	public User getUser(String userName) {
		// TODO Auto-generated method stub
		System.out.println("in service :"+userName);
		return userDAO.getUser(userName);
	}

}
