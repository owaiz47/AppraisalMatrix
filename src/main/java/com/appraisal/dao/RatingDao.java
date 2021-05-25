package com.appraisal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appraisal.entities.Rating;

@Repository
public interface RatingDao extends JpaRepository<Rating, Long>{
	public List<Rating> findByRatedById(long id);
	public List<Rating> findByEmployeeId(long id);
	public List<Rating> findByRatedByIdAndEmployeeId(long ratedById, long employeeId);
	
	@Query(value = "SELECT AVG(r.rating) FROM rating r WHERE r.rated_skill = ?1 And r.rated_employee = ?2" , nativeQuery = true)
	public double avgSkillRating(long skillId, long empId);
	
	@Query(value = "SELECT r.rated_skill , AVG(r.rating) FROM appraisal.rating r WHERE r.rated_employee = ?1 group by r.rated_skill", nativeQuery = true)
	public List<Object[]> getAvgSkillRatings(long empId);
}
