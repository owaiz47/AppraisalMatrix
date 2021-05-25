package com.appraisal.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appraisal.dto.AuthRequest;
import com.appraisal.entities.User;
import com.appraisal.services.UserService;
import com.appraisal.utils.JwtUtil;

@RestController("/")
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService UserService;

	@PostMapping("/authenticate")
	public ResponseEntity<Object> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		Map<String, String> res = new HashMap<String, String>();
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
		}
		res.put("token", jwtUtil.generateToken(authRequest.getUsername()));
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}

	@GetMapping("/authenticated_user")
	public User getAuthenticatedUser() throws Exception {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == null)
			return null;
		User user = UserService.getUserByUsername(username);
		return user;
	}
}
