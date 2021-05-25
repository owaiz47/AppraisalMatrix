package com.appraisal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appraisal.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	public User findByUsernameOrEmail(String username, String email);
	public List<User> findByUsernameOrFullnameContainingIgnoreCase(String username, String name);
}
