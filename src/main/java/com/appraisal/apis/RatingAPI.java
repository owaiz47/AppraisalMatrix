package com.appraisal.apis;

import java.util.List;

import com.appraisal.entities.Rating;
import com.appraisal.entities.User;

public interface RatingAPI {
	public Rating saveRating(Rating rating);
	public List<Rating> saveRatings(List<Rating> ratings);
	public List<Rating> getRatingsByUser(long userId);
	public List<Rating> getRatingOfEmployee(long employeeId);
	public Rating deleteRating(long id);
	public List<Rating> getRatingsOfEmpFromMan(long manId, long empId);
	public double getAvgRatingOfEmpForSkill(long empId, long skillId);
	public List<Object[]> getAvgSkillRatingOfEmp(long empId);
}
