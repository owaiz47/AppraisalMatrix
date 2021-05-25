package com.appraisal.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.appraisal.apis.EmployeeAPI;

@RestController("/employees")
public interface EmployeeController extends EmployeeAPI{

}
