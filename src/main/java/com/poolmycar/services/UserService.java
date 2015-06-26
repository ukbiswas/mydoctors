package com.poolmycar.services;

import com.poolmycar.domain.User;

public interface UserService {
	public void saveUser(User user);
	public void updateUser();
	public void deleteUser();
	public User getUser(String userId);
}
