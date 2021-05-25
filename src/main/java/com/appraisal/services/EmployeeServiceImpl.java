package com.appraisal.services;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appraisal.dao.EmployeeDao;
import com.appraisal.entities.Employee;
import com.appraisal.entities.Rating;
import com.appraisal.entities.Skill;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final double MAX_RATING = 10;

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private SkillService skillService;

	@Autowired
	private RatingService ratingService;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employeeOpt = employeeDao.findById(id);
		if (employeeOpt.isPresent()) {
			Employee employee = employeeOpt.get();
			employee.setAverageRating(getAverageRatingOfEmp(employee.getId()));
			return employee;
		} else {
			return null;
		}
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		List<Employee> emps = employeeDao.findByEmployeeNameContainingIgnoreCase(name);
		if (emps != null) {
			for (Employee emp : emps) {
				emp.setAverageRating(getAverageRatingOfEmp(emp.getId()));
			}
		}
		return emps;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> emps = employeeDao.findAll();
		if (emps != null) {
			for (Employee emp : emps) {
				emp.setAverageRating(getAverageRatingOfEmp(emp.getId()));
			}
		}
		return emps;
	}

	@Override
	public Employee deleteEmployee(long id) {
		Employee emp2del = getEmployeeById(id);
		employeeDao.delete(emp2del);
		return emp2del;
	}

	@Override
	public double getAverageRatingOfEmp(long id) {
		List<Object[]> avgSkillRatingList = ratingService.getAvgSkillRatingOfEmp(id);
		Map<Long, Double> skillRateMap = new HashMap<Long, Double>();
		
		for (Object obj[] : avgSkillRatingList) {
			long skillId = ((BigInteger) obj[0]).longValue();
			double rating = (double) obj[1];
			skillRateMap.put(skillId,rating);
		}
		
		List<Skill> skills = skillService.getSkills();
		if (skills == null || skills.isEmpty())
			return 0;
		List<Rating> ratings = ratingService.getRatingOfEmployee(id);
		double avgRat = 0;
		double sumRatings = 0;
		for (Skill skill : skills) {
			double skillRating = 0;
			if(skillRateMap.containsKey(skill.getId())) {
				skillRating = skillRateMap.get(skill.getId());
			}
			sumRatings = sumRatings + ((skillRating / MAX_RATING) * skill.getWeightage());
		}
		if (sumRatings > 0) {
			avgRat = sumRatings / skillService.getTotalWeight();//Divide by is total weight to get 
			avgRat = avgRat * MAX_RATING;
		}
		DecimalFormat format = new DecimalFormat("##.00");
		return Double.parseDouble(format.format(avgRat));
	}

	@Override
	public List<Employee> saveEmployees(List<Employee> employees) {
		List<Employee> emps = employeeDao.saveAll(employees);
		if (emps != null) {
			for (Employee emp : emps) {
				emp.setAverageRating(getAverageRatingOfEmp(emp.getId()));
			}
		}
		return emps;
	}

}
