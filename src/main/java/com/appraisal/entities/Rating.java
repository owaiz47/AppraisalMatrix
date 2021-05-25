package com.appraisal.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating extends AbstractPersistentObject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private double rating;
	
	@ManyToOne(cascade = CascadeType.DETACH, targetEntity = User.class)
	@JoinColumn(name = "rated_by_user", referencedColumnName = "id")
	private User ratedBy;
	
	@ManyToOne(cascade = CascadeType.DETACH, targetEntity = Employee.class)
	@JoinColumn(name = "rated_employee", referencedColumnName = "id")
	private Employee employee;
	
	@ManyToOne(cascade = CascadeType.DETACH, targetEntity = Skill.class)
	@JoinColumn(name = "rated_skill", referencedColumnName = "id")
	private Skill skill;

	public Rating(double rating, User ratedBy, Employee employee, Skill skill) {
		super();
		this.rating = rating;
		this.ratedBy = ratedBy;
		this.employee = employee;
		this.skill = skill;
	}

	public Rating() {
	}

	public Rating(Long id, Date createdOn, Date lastModifiedOn) {
		super(id, createdOn, lastModifiedOn);
		// TODO Auto-generated constructor stub
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public User getRatedBy() {
		return ratedBy;
	}

	public void setRatedBy(User ratedBy) {
		this.ratedBy = ratedBy;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	

}
