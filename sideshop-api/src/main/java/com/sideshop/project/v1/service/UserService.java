package com.sideshop.project.v1.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.UserRec;

public interface UserService {

	public List<UserRec> getAllUsers();

	public UserRec createUser(UserRec userRec);

	public UserRec replaceUser(UserRec userRec, String userId);

	public UserRec getUser(String userId);

	public JsonNode deleteUser(String userId);

}
