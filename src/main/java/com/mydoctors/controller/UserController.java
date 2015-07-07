package com.mydoctors.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poolmycar.domain.User;
import com.poolmycar.services.UserService;


@Controller
@RequestMapping(value="/user")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/{email}",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public User getUserInfo(@PathVariable String email) {
		System.out.println("in controller :1");
		User user = userService.getUser(email);
		System.out.println("user="+user);
		return user;
	}

}
