package com.appraisal.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appraisal.dao.SkillDao;
import com.appraisal.entities.Rating;
import com.appraisal.entities.Skill;

@Transactional
@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDao skillDao;
	
	@Autowired
	private RatingService ratingService;
	
	@Override
	public Skill saveSkill(Skill skill) {
		return skillDao.save(skill);
	}

	@Override
	public List<Skill> saveSkills(List<Skill> skills) {
		return skillDao.saveAll(skills);
	}

	@Override
	public List<Skill> getSkillByName(String skillName) {
		return skillDao.findBySkillNameContainingIgnoreCase(skillName);
	}

	@Override
	public List<Skill> getSkills() {
		return skillDao.findAll();
	}

	@Override
	public Skill deleteSkill(long id) {
		Optional<Skill> skill2del = skillDao.findById(id);
		if(!skill2del.isPresent()) {
			return null;
		}
		skillDao.delete(skill2del.get());
		return skill2del.get();
	}

	@Override
	public List<Skill> getSkillAvgOfEmp(long empId) {
		List<Skill> skills = skillDao.findAll();
		for(Skill sk : skills) {
			sk.setAvgSkillRatingOfEmp(ratingService.getAvgRatingOfEmpForSkill(empId, sk.getId()));
		}
		return skills;
	}

	@Override
	public long getSkillsCount() {
		return skillDao.count();
	}

	@Override
	public long getTotalWeight() {
		return skillDao.geTotalWeight();
	}

}
