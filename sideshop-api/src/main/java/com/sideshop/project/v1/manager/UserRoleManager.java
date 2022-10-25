package com.sideshop.project.v1.manager;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.UserRole;

public interface UserRoleManager {

	public List<UserRole> getAllUserRoles();

	public UserRole createUserRole(UserRole userRole);

	public UserRole replaceUserRole(UserRole userRole, String userRoleId);

	public UserRole getUserRole(String userRoleId);

	public JsonNode deleteUserRole(String userRoleId);

}
