package com.sideshop.project.v1.api;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.UserRole;
import com.sideshop.project.v1.manager.UserRoleManager;

@RestController
@RequestMapping(value = "/UserRoleController")
public class UserRoleController {

	@Autowired
	UserRoleManager userRoleManager;

	@RequestMapping(value = "/userroles", produces = { "application/json" })
	public List<UserRole> getUserRoles() {
		return userRoleManager.getAllUserRoles();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/userrole", produces = { "application/json" }, consumes = {
			"application/json" })
	public UserRole createUserRole(@RequestBody UserRole userRole) {
		return userRoleManager.createUserRole(userRole);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/userrole/{userRoleId}", produces = {
			"application/json" }, consumes = { "application/json" })
	public UserRole updateUserRole(@RequestBody UserRole userRole, @PathParam("userRoleId") String userRoleId) {
		return userRoleManager.replaceUserRole(userRole, userRoleId);
	}

	@RequestMapping(value = "/userrole/{userRoleId}", produces = { "application/json" })
	public UserRole getUserRole(@PathParam("userRoleId") String userRoleId) {
		return userRoleManager.getUserRole(userRoleId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/userrole/{userRoleId}", produces = { "application/json" })
	public JsonNode deleteUserRole(@PathParam("userRoleId") String userRoleId) {
		return userRoleManager.deleteUserRole(userRoleId);
	}
}