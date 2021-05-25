package com.appraisal.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appraisal.dao.RatingDao;
import com.appraisal.entities.Employee;
import com.appraisal.entities.Rating;

@Transactional
@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDao ratingDao;
	
	@Override
	public Rating saveRating(Rating rating) {
		return ratingDao.save(rating);
	}

	@Override
	public List<Rating> saveRatings(List<Rating> ratings) {
		return ratingDao.saveAll(ratings);
	}

	@Override
	public List<Rating> getRatingsByUser(long userId) {
		return ratingDao.findByRatedById(userId);
	}

	@Override
	public List<Rating> getRatingOfEmployee(long employeeId) {
		return ratingDao.findByEmployeeId(employeeId);
	}

	@Override
	public Rating deleteRating(long id) {
		Rating rat2del = ratingDao.getById(id);
		ratingDao.delete(rat2del);
		return rat2del;
	}

	@Override
	public List<Rating> getRatingsOfEmpFromMan(long manId, long empId) {
		return ratingDao.findByRatedByIdAndEmployeeId(manId, empId);
	}

	@Override
	public double getAvgRatingOfEmpForSkill(long empId, long skillId) {
		return ratingDao.avgSkillRating(skillId, empId);
	}

	@Override
	public List<Object[]> getAvgSkillRatingOfEmp(long empId) {
		return ratingDao.getAvgSkillRatings(empId);
	}

}
