package com.appraisal.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appraisal.dao.UserDao;
import com.appraisal.entities.Employee;
import com.appraisal.entities.Skill;
import com.appraisal.entities.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User getUserById(long userId) {
		Optional<User> user = userDao.findById(userId);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.findByUsernameOrEmail(username, username);
	}

	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}

	@Override
	public User deleteUser(long id) {
		User user2del = getUserById(id);
		if (user2del != null) {
			userDao.delete(user2del);
		}
		return user2del;
	}

	@Override
	public List<User> saveUsers(List<User> users) {
		return userDao.saveAll(users);
	}

	@Override
	public List<User> getUserByName(String name) {
		return userDao.findByUsernameOrFullnameContainingIgnoreCase(name, name);
	}

}
