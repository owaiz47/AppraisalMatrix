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

import com.appraisal.entities.Employee;
import com.appraisal.services.EmployeeService;

@RestController("/employees")
public class EmployeeControllerImpl implements EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees/employee")
	@Override
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/employees/id/{id}")
	@Override
	public Employee getEmployeeById(@PathVariable long id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/employees/name/{name}")
	@Override
	public List<Employee> getEmployeesByName(@PathVariable String name) {
		return employeeService.getEmployeesByName(name);
	}
	
	@GetMapping("/employees")
	@Override
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@DeleteMapping("/employees/{id}")
	@Override
	public Employee deleteEmployee(@PathVariable long id) {
		return employeeService.deleteEmployee(id);
	}

	@GetMapping("/employees/avg_rating/{id}")
	@Override
	public double getAverageRatingOfEmp(@PathVariable long id) {
		return employeeService.getAverageRatingOfEmp(id);
	}

	@PostMapping("/employees")
	@Override
	public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {
		return employeeService.saveEmployees(employees);
	}

}
