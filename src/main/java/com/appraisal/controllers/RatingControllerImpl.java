package com.appraisal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appraisal.entities.Rating;
import com.appraisal.services.RatingService;

@RestController("/ratings")
public class RatingControllerImpl implements RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/ratings/rating")
	@Override
	public Rating saveRating(@RequestBody Rating rating) {
		return ratingService.saveRating(rating);
	}
	
	@PostMapping("/ratings")
	@Override
	public List<Rating> saveRatings(@RequestBody List<Rating> ratings) {
		return ratingService.saveRatings(ratings);
	}

	@GetMapping("/ratings/user/{userId}")
	@Override
	public List<Rating> getRatingsByUser(@PathVariable long userId) {
		return ratingService.getRatingOfEmployee(userId);
	}

	@GetMapping("/ratings/employee/{employeeId}")
	@Override
	public List<Rating> getRatingOfEmployee(@PathVariable long employeeId) {
		return ratingService.getRatingOfEmployee(employeeId);
	}

	@DeleteMapping("/ratings/{id}")
	@Override
	public Rating deleteRating(long id) {
		return ratingService.deleteRating(id);
	}

	@GetMapping("/ratings/{manId}/{empId}")
	@Override
	public List<Rating> getRatingsOfEmpFromMan(@PathVariable long manId, @PathVariable long empId) {
		return ratingService.getRatingsOfEmpFromMan(manId, empId);
	}

	@GetMapping("/ratings/emp/{empId}/{skillId}")
	@Override
	public double getAvgRatingOfEmpForSkill(@PathVariable long empId,@PathVariable long skillId) {
		return ratingService.getAvgRatingOfEmpForSkill(empId, skillId);
	}

	@Override
	public List<Object[]> getAvgSkillRatingOfEmp(long empId) {
		// TODO Auto-generated method stub
		return null;
	}

}
