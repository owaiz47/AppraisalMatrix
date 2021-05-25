package com.appraisal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appraisal.entities.Skill;
import com.appraisal.services.SkillService;

@RestController("/skills")
public class SkillsControllerImpl implements SkillController {

	@Autowired
	private SkillService skillService;
	
	@PostMapping("/skills/skill")
	@Override
	public Skill saveSkill(@RequestBody Skill skill) {
		return skillService.saveSkill(skill);
	}

	@PostMapping("/skills")
	@Override
	public List<Skill> saveSkills(@RequestBody List<Skill> skills) {
		return skillService.saveSkills(skills);
	}

	@GetMapping("/skills/{skillName}")
	@Override
	public List<Skill> getSkillByName(@PathVariable String skillName) {
		return skillService.getSkillByName(skillName);
	}

	@GetMapping("/skills")
	@Override
	public List<Skill> getSkills() {
		return skillService.getSkills();
	}

	@DeleteMapping("/skills/{id}")
	@Override
	public Skill deleteSkill(@PathVariable long id) {
		return skillService.deleteSkill(id);
	}

	@GetMapping("/skills/emp/{empId}")
	@Override
	public List<Skill> getSkillAvgOfEmp(@PathVariable long empId) {
		return skillService.getSkillAvgOfEmp(empId);
	}

	@Override
	public long getSkillsCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTotalWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
