package com.appraisal.apis;

import java.util.List;

import com.appraisal.entities.Employee;

public interface EmployeeAPI {
	public Employee saveEmployee(Employee employee);
	public Employee getEmployeeById(long id);
	public List<Employee> getEmployeesByName(String name);
	public List<Employee> getEmployees();
	public Employee deleteEmployee(long id);
	public double getAverageRatingOfEmp(long id); 
	public List<Employee> saveEmployees(List<Employee> employees);
}
