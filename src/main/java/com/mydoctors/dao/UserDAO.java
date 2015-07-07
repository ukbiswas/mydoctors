package com.mydoctors.dao;

import com.mydoctors.domain.User;

public interface UserDAO {
	public User getUser(String email);
	public void saveUser(User user);
	public void updateUser(User user);
}
