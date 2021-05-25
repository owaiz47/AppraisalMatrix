package com.appraisal.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.appraisal.apis.SkillAPI;

@RestController("/skills")
public interface SkillController extends SkillAPI {

}
