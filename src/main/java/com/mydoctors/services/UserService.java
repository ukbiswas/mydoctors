package com.mydoctors.services;

import com.mydoctors.domain.User;

public interface UserService {
	public void saveUser(User user);
	public void updateUser();
	public void deleteUser();
	public User getUser(String userId);
}
