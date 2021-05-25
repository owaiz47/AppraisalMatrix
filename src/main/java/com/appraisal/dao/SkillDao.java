package com.appraisal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appraisal.entities.Skill;

@Repository
public interface SkillDao extends JpaRepository<Skill, Long>{
	public List<Skill> findBySkillNameContainingIgnoreCase(String name);
	@Query("SELECT SUM(s.weightage) FROM Skill s")
	public long geTotalWeight();
}
