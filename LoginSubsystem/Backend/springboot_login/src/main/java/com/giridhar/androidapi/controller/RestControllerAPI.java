package com.giridhar.androidapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giridhar.androidapi.model.User;
import com.giridhar.androidapi.repository.UserRepository;

@RestController
public class RestControllerAPI {
	
	@Autowired
	UserRepository ur;
	
	@PostMapping("/api/register")
	public String register(@Valid @RequestBody User user) {
		
		List<User> users = ur.findAll();
		System.out.println("New User -> " + user);
		
		for (User u: users) {
			if (user.equals(u)) {
				System.out.println("User already exists!");
				return "USER_ALREADY_EXISTS";
			}
		}
		
		ur.save(user);
		return "SUCCESS";
		
	}
	
	@PostMapping("/api/login")
	public String login(@Valid @RequestBody User user) {
		
		List<User> users = ur.findAll();
		
		for (User u: users) {
			if (u.equals(user)) {
				return user.getUserName();
			}
		}
		
		return "FAILURE";
		
	}

}
