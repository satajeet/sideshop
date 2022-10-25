package com.sideshop.project.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.entity.UserCredential;
import com.sideshop.project.v1.manager.UserCredentialManager;
import com.sideshop.project.v1.service.UserCredentialService;

@Service
public class UserCredentialServiceImpl implements UserCredentialService {

    @Autowired
    UserCredentialManager userCredentialManager;

    @Override
    public List<UserCredential> getAllUserCredentials() {
	return userCredentialManager.getAllUserCredentials();
    }

    @Override
    public UserCredential createUserCredential(UserCredential userCredential) {
	return userCredentialManager.createUserCredential(userCredential);
    }

    @Override
    public UserCredential replaceUserCredential(UserCredential userCredential, String userCredentialId) {
	return userCredentialManager.replaceUserCredential(userCredential, userCredentialId);
    }

    @Override
    public UserCredential getUserCredential(String userCredentialId) {
	return userCredentialManager.getUserCredential(userCredentialId);
    }

    @Override
    public JsonNode deleteUserCredential(String userCredentialId) {
	userCredentialManager.deleteUserCredential(userCredentialId);
	return SideshopConstants.OBJECTMAPPER.createObjectNode();
    }

    @Override
    public String checkUserCredential(UserCredential userCredential) {
	return null;
    }
}
