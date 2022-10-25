package com.sideshop.project.v1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.entity.UserRole;
import com.sideshop.project.v1.manager.UserRoleManager;
import com.sideshop.project.v1.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleManager userRoleManager;

    @Override
    public List<UserRole> getAllUserRoles() {
	Iterable<UserRole> userRoles = userRoleManager.getAllUserRoles();
	List<UserRole> userRolesList = new ArrayList<>();
	userRoles.forEach(userRolesList::add);
	return userRolesList;
    }

    @Override
    public UserRole createUserRole(UserRole userRole) {
	return userRoleManager.createUserRole(userRole);
    }

    @Override
    public UserRole replaceUserRole(UserRole userRole, String userRoleId) {
	userRole.setUserRoleId(userRoleId);
	return userRoleManager.replaceUserRole(userRole, userRoleId);
    }

    @Override
    public UserRole getUserRole(String userRoleId) {
	return userRoleManager.getUserRole(userRoleId);
    }

    @Override
    public JsonNode deleteUserRole(String userRoleId) {
	userRoleManager.deleteUserRole(userRoleId);
	return SideshopConstants.OBJECTMAPPER.createObjectNode();
    }
}
