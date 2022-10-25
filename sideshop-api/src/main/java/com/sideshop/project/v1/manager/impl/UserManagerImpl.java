package com.sideshop.project.v1.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.dao.UserDao;
import com.sideshop.project.v1.entity.UserRec;
import com.sideshop.project.v1.manager.UserManager;

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserRec> getAllUsers() {
	Iterable<UserRec> users = userDao.findAll();
	List<UserRec> usersList = new ArrayList<>();
	users.forEach(usersList::add);
	return usersList;
    }

    @Override
    public UserRec createUser(UserRec user) {
	return userDao.save(user);
    }

    @Override
    public UserRec replaceUser(UserRec user, String userId) {
	user.setUserId(userId);
	return userDao.save(user);
    }

    @Override
    public UserRec getUser(String userId) {
	return userDao.findById(userId).get();
    }

    @Override
    public JsonNode deleteUser(String userId) {
	userDao.deleteById(userId);
	return SideshopConstants.OBJECTMAPPER.createObjectNode();
    }
}
