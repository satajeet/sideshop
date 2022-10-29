package com.sideshop.project.v1.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.dao.UserRoleDao;
import com.sideshop.project.v1.entity.UserRole;
import com.sideshop.project.v1.exception.SideshopException;
import com.sideshop.project.v1.manager.UserRoleManager;
import com.sideshop.project.v1.validator.UserRoleValidator;

@Service
@Transactional
public class UserRoleManagerImpl implements UserRoleManager {

	@Autowired
	UserRoleDao userRoleDao;

	@Autowired
	UserRoleValidator userRoleValidator;

	@Override
	public List<UserRole> getAllUserRoles() {
		Iterable<UserRole> userRoles = userRoleDao.findAll();
		List<UserRole> userRolesList = new ArrayList<>();
		userRoles.forEach(userRolesList::add);
		return userRolesList;
	}

	@Override
	@Transactional
	public UserRole createUserRole(UserRole userRole) {
		userRole.set_id(UUID.randomUUID().toString());
		return userRoleDao.save(userRole);
	}

	@Override
	@Transactional
	public UserRole replaceUserRole(UserRole userRole, String userRoleId) {
		if (!userRoleValidator.validateUserRoleId(userRoleId)) {
			throw new SideshopException("UserRoleId is invalid");
		}
		userRole.set_id(userRoleId);
		return userRoleDao.save(userRole);
	}

	@Override
	public UserRole getUserRole(String userRoleId) {
		if (!userRoleValidator.validateUserRoleId(userRoleId)) {
			throw new SideshopException("UserRoleId is invalid");
		}
		return userRoleDao.findById(userRoleId).get();
	}

	@Override
	@Transactional
	public JsonNode deleteUserRole(String userRoleId) {
		if (!userRoleValidator.validateUserRoleId(userRoleId)) {
			throw new SideshopException("UserRoleId is invalid");
		}
		userRoleDao.deleteById(userRoleId);
		return SideshopConstants.OBJECTMAPPER.createObjectNode();
	}
}
