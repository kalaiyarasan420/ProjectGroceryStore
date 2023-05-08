package com.EducationalLoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EducationalLoan.model.LoginModel;
import com.EducationalLoan.model.UserModel;
import com.EducationalLoan.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userSer;
	
	

	@GetMapping(value="/getLogin")
	public List<UserModel> getLogin()
	{
		return userSer.getLogin();
	}
	
	@PostMapping(value="/signUp")
	public UserModel saveLogin(@RequestBody UserModel u)
	{
		return userSer.saveLogin(u);
	}
	
	@PostMapping(value="/login")
	public String validateUserLogin(@RequestBody LoginModel l)
	{
		return userSer.validateUserLogin(l.getEmail(),l.getPassword());
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") int id)
	{
		userSer.deleteUser(id);
		
	}
}
