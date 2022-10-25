package com.sideshop.project.v1.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.dao.UserCredentialDao;
import com.sideshop.project.v1.entity.UserCredential;
import com.sideshop.project.v1.manager.UserCredentialManager;

@Service
public class UserCredentialManagerImpl implements UserCredentialManager {

	@Autowired
	UserCredentialDao userCredentialDao;

	@Override
	public List<UserCredential> getAllUserCredentials() {
		Iterable<UserCredential> userCredentials = userCredentialDao.findAll();
		List<UserCredential> userCredentialsList = new ArrayList<>();
		userCredentials.forEach(userCredentialsList::add);
		return userCredentialsList;
	}

	@Override
	public UserCredential createUserCredential(UserCredential userCredential) {
		return userCredentialDao.save(userCredential);
	}

	@Override
	public UserCredential replaceUserCredential(UserCredential userCredential, String userCredentialId) {
		userCredential.setUserCredentialId(userCredentialId);
		return userCredentialDao.save(userCredential);
	}

	@Override
	public UserCredential getUserCredential(String userCredentialId) {
		return userCredentialDao.findById(userCredentialId).get();
	}

	@Override
	public JsonNode deleteUserCredential(String userCredentialId) {
		userCredentialDao.deleteById(userCredentialId);
		return SideshopConstants.OBJECTMAPPER.createObjectNode();
	}

	@Override
	public String checkUserCredential(UserCredential userCredential) {
		// TODO Auto-generated method stub
		return null;
	}
}
