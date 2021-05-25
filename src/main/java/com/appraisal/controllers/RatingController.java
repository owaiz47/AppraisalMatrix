package com.appraisal.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.appraisal.apis.RatingAPI;

@RestController("/ratings")
public interface RatingController extends RatingAPI{

}
