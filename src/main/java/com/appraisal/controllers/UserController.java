package com.appraisal.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.appraisal.apis.UserAPI;

@RestController("/users")
public interface UserController extends UserAPI{

}
