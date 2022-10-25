package com.sideshop.project.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.entity.UserRec;
import com.sideshop.project.v1.manager.UserManager;
import com.sideshop.project.v1.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserManager userManager;

	@Override
	public List<UserRec> getAllUsers() {
		return userManager.getAllUsers();
	}

	@Override
	public UserRec createUser(UserRec user) {
		return userManager.createUser(user);
	}

	@Override
	public UserRec replaceUser(UserRec user, String userId) {
		return userManager.replaceUser(user, userId);
	}

	@Override
	public UserRec getUser(String userId) {
		return userManager.getUser(userId);
	}

	@Override
	public JsonNode deleteUser(String userId) {
		userManager.deleteUser(userId);
		return SideshopConstants.OBJECTMAPPER.createObjectNode();
	}
}
