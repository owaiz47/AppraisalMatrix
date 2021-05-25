package com.appraisal.apis;

import java.util.List;

import com.appraisal.entities.User;

public interface UserAPI {
	public User saveUser(User user);
	public User getUserById(long userId);
	public User getUserByUsername(String username);
	public List<User> getUsers();
	public User deleteUser(long id);
	public List<User> saveUsers(List<User> users);
	public List<User> getUserByName(String name);
}
