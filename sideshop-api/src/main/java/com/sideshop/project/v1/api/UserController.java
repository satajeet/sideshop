package com.sideshop.project.v1.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.UserRec;
import com.sideshop.project.v1.manager.UserManager;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserManager userManager;

	@RequestMapping(value = "/users", produces = { "application/json" })
	public List<UserRec> getUsers() {
		return userManager.getAllUsers();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/user", produces = { "application/json" }, consumes = {
			"application/json" })
	public UserRec createUser(@RequestBody UserRec userRec) {
		return userManager.createUser(userRec);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/user/{userId}", produces = {
			"application/json" }, consumes = { "application/json" })
	public UserRec updateUser(@RequestBody UserRec userRec, @PathVariable("userId") String userId) {
		return userManager.replaceUser(userRec, userId);
	}

	@RequestMapping(value = "/user/{userId}", produces = { "application/json" })
	public UserRec getUser(@PathVariable("userId") String userId) {
		return userManager.getUser(userId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{userId}", produces = { "application/json" })
	public JsonNode deleteUser(@PathVariable("userId") String userId) {
		return userManager.deleteUser(userId);
	}
}