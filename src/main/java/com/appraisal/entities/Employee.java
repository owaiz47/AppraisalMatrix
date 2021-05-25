package com.appraisal.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.appraisal.services.EmployeeService;
import com.appraisal.services.EmployeeServiceImpl;
import com.fasterxml.jackson.annotation.JsonValue;

enum ExpUnit{
	MONTHS, YEARS;
	
	@JsonValue
	public int toValue() {
		return ordinal();
	}
}

@Entity
@Table
public class Employee extends AbstractPersistentObject implements Serializable{
	private static final long serialVersionUID = 1L;

	private String email;
	private String employeeName;
	private String designation;
	private Double experience;
	@Enumerated(EnumType.ORDINAL)
	private ExpUnit expUnit = ExpUnit.YEARS;
	
	@Transient
	private Double averageRating;
	
	@PostLoad
	public void fillTransients() {
		//if(employeeService == null)employeeService = new EmployeeServiceImpl();
		//averageRating = employeeService.getAverageRatingOfEmp(this.getId());
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public Employee(String employeeName, String designation, Double experience, Double averageRating, ExpUnit expUnit, String email) {
		super();
		this.employeeName = employeeName;
		this.designation = designation;
		this.experience = experience;
		this.averageRating = averageRating;
		this.expUnit = expUnit;
		this.email = email;
	}

	public ExpUnit getExpUnit() {
		return expUnit;
	}

	public void setExpUnit(ExpUnit expUnit) {
		this.expUnit = expUnit;
	}

	public Employee() {
	}

	public Employee(Long id, Date createdOn, Date lastModifiedOn) {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
