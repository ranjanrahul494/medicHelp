package com.medics.medicHelp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medics.medicHelp.exception.UserNotFoundException;
import com.medics.medicHelp.model.User;
import com.medics.medicHelp.model.UserAddress;
import com.medics.medicHelp.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {
	@Autowired
	private UserService userService;

	/* add new user in user table inside medicHelp */
	
	@PostMapping("/registration")
	public String addUser(@RequestBody User user) {
		try {
			userService.addUser(user);
			return "Hi"+ user.getFirstName()+" "+user.getMedialName()+" "+user.getLastName()+" "+"Registration done successfully ";
		} catch (NullPointerException e) {
			throw new RuntimeException("something is null");
		}
	}
	/* add new user in user table inside medicHelp */
	@PostMapping("/login")
	public boolean loginUser(@RequestBody User user) {
		User userDetails=null;
		try {
			userDetails=userService.getUserDetails(user.getPhoneNumber());
		} catch (NullPointerException e) {
			throw new RuntimeException("something is null");
		}
		
		if(null!=userDetails && userDetails.getPassword().equals(user.getPassword())) {
			return true;
		}
		throw new UserNotFoundException("user not found");
		//return userDetails;
		
	}

	/*.......... update and upload userAddress............ */
	@PostMapping("/address/{id}")
	public String updateUserAddress(@RequestBody UserAddress userAddress,@PathVariable String id)  {
		try {
			userService.updateUserAddress(id,userAddress);
		} catch (NullPointerException e) {
			throw new RuntimeException("something is null");
		}
		
		return "success";
	}
	
}
