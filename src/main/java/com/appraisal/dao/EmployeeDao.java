package com.appraisal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appraisal.entities.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long>{
	public List<Employee> findByEmployeeNameContainingIgnoreCase(String name);
}
