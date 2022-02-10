package com.example.demo.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.UserDto;
import com.example.demo.ui.model.request.UserDetailsRequestModel;
import com.example.demo.ui.model.response.UserRest;

@RestController
@RequestMapping("users") //http://localhost.com:8080/users
public class UserController {
	
	@Autowired
	UserService userService;
	@GetMapping
	public String getUsers() {
		return "get user detail";
	}
	
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetail) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetail, userDto);
		UserDto createdUser = userService.createUser(userDto);
		UserRest returnValue = new UserRest();
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}
	
	@PutMapping
	public String updateUser() {
		return "update user";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user";
	}
}
