package com.sideshop.project.v1.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.UserCredential;

public interface UserCredentialService {

	public List<UserCredential> getAllUserCredentials();

	public UserCredential createUserCredential(UserCredential userCredential);

	public UserCredential replaceUserCredential(UserCredential userCredential, String userCredentialsId);

	public UserCredential getUserCredential(String userCredentialsId);

	public JsonNode deleteUserCredential(String userCredentialsId);

	public String checkUserCredential(UserCredential userCredential);

}
