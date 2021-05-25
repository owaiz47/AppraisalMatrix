package com.appraisal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appraisal.entities.User;
import com.appraisal.services.UserService;

@RestController("/users")
public class UserControllerImpl implements UserController{
	
	@Autowired
	private UserService userService;

	@PostMapping("/users/user")
	@Override
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/users/{id}")
	@Override
	public User getUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}

	@GetMapping("/users/username/{username}")
	@Override
	public User getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

	@GetMapping("/users")
	@Override
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/users/del/{id}")
	@Override
	public User deleteUser(@PathVariable long id) {
		return userService.deleteUser(id);
	}

	@PostMapping("/users")
	@Override
	public List<User> saveUsers(@RequestBody List<User> users) {
		return userService.saveUsers(users);
	}

	@GetMapping("/users/name/{name}")
	@Override
	public List<User> getUserByName(@PathVariable String name) {
		return userService.getUserByName(name);
	}

}
