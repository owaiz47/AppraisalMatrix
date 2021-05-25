package com.appraisal.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Skill extends AbstractPersistentObject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String skillName;
	private int weightage;
	
	@javax.persistence.Transient
	private double avgSkillRatingOfEmp;
	
	/*
	 * @OneToOne(mappedBy = "rating") private Rating rating;
	 */
	
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public int getWeightage() {
		return weightage;
	}
	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}
	public double getAvgSkillRatingOfEmp() {
		return avgSkillRatingOfEmp;
	}
	public void setAvgSkillRatingOfEmp(double avgSkillRatingOfEmp) {
		this.avgSkillRatingOfEmp = avgSkillRatingOfEmp;
	}
	public Skill(String skillName, int weightage) {
		super();
		this.skillName = skillName;
		this.weightage = weightage;
	}
	public Skill() {
	}
	public Skill(Long id, Date createdOn, Date lastModifiedOn) {
	}
	
	

}
