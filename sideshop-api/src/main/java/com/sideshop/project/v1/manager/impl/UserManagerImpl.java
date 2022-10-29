package com.sideshop.project.v1.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.dao.UserDao;
import com.sideshop.project.v1.entity.UserRec;
import com.sideshop.project.v1.exception.SideshopException;
import com.sideshop.project.v1.manager.UserManager;
import com.sideshop.project.v1.validator.UserRoleValidator;
import com.sideshop.project.v1.validator.UserValidator;

@Service
@Transactional
public class UserManagerImpl implements UserManager {

	@Autowired
	UserDao userDao;

	@Autowired
	UserRoleValidator userRoleValidator;

	@Autowired
	UserValidator userValidator;

	@Override
	public List<UserRec> getAllUsers() {
		Iterable<UserRec> users = userDao.findAll();
		List<UserRec> usersList = new ArrayList<>();
		users.forEach(usersList::add);
		return usersList;
	}

	@Override
	@Transactional
	public UserRec createUser(UserRec user) {
		if (!userRoleValidator.validateUserRoleId(user.getUserRoleId())) {
			throw new SideshopException("UserRoleId is invalid");
		}
		user.set_id(UUID.randomUUID().toString());
		return userDao.save(user);
	}

	@Override
	@Transactional
	public UserRec replaceUser(UserRec user, String userId) {
		if (!userValidator.validateUserId(userId)) {
			throw new SideshopException("UserId is invalid");
		}
		if (!userRoleValidator.validateUserRoleId(user.getUserRoleId())) {
			throw new SideshopException("UserRoleId is invalid");
		}
		user.set_id(userId);
		return userDao.save(user);
	}

	@Override
	public UserRec getUser(String userId) {
		if (!userValidator.validateUserId(userId)) {
			throw new SideshopException("UserId is invalid");
		}
		return userDao.findById(userId).get();
	}

	@Override
	@Transactional
	public JsonNode deleteUser(String userId) {
		if (!userValidator.validateUserId(userId)) {
			throw new SideshopException("UserId is invalid");
		}
		userDao.deleteById(userId);
		return SideshopConstants.OBJECTMAPPER.createObjectNode();
	}
}
