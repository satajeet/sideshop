package com.sideshop.project.v1.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.dao.UserRoleDao;
import com.sideshop.project.v1.entity.UserRole;
import com.sideshop.project.v1.manager.UserRoleManager;

@Service
public class UserRoleManagerImpl implements UserRoleManager {

    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public List<UserRole> getAllUserRoles() {
	Iterable<UserRole> userRoles = userRoleDao.findAll();
	List<UserRole> userRolesList = new ArrayList<>();
	userRoles.forEach(userRolesList::add);
	return userRolesList;
    }

    @Override
    public UserRole createUserRole(UserRole userRole) {
	return userRoleDao.save(userRole);
    }

    @Override
    public UserRole replaceUserRole(UserRole userRole, String userRoleId) {
	userRole.setUserRoleId(userRoleId);
	return userRoleDao.save(userRole);
    }

    @Override
    public UserRole getUserRole(String userRoleId) {
	return userRoleDao.findById(userRoleId).get();
    }

    @Override
    public JsonNode deleteUserRole(String userRoleId) {
	userRoleDao.deleteById(userRoleId);
	return SideshopConstants.OBJECTMAPPER.createObjectNode();
    }
}
