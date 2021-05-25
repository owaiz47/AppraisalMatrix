package com.appraisal.apis;

import java.util.List;

import com.appraisal.entities.Skill;

public interface SkillAPI {
	public Skill saveSkill(Skill skill);
	public List<Skill> saveSkills(List<Skill> skills);
	public List<Skill> getSkillByName(String skillName);
	public List<Skill> getSkills();
	public Skill deleteSkill(long id);
	public List<Skill> getSkillAvgOfEmp(long empId);
	public long getSkillsCount();
	public long getTotalWeight();
}
