package com.sideshop.project.v1.api;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.UserCredential;
import com.sideshop.project.v1.manager.UserCredentialManager;

@RestController
@RequestMapping(value = "/UserCredentialController")
public class UserCredentialController {

    @Autowired
    UserCredentialManager userCredentialManager;

    @RequestMapping(value = "/usercredentials", produces = { "application/json" })
    public List<UserCredential> getUsers() {
	return userCredentialManager.getAllUserCredentials();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/usercredentials", produces = {
	    "application/json" }, consumes = { "application/json" })
    public UserCredential createUserCredential(@RequestBody UserCredential userCredential) {
	return userCredentialManager.createUserCredential(userCredential);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/usercredentials/{userCredentialId}", produces = {
	    "application/json" }, consumes = { "application/json" })
    public UserCredential updateUserCredential(@RequestBody UserCredential userCredential,
	    @PathParam("userCredentialId") String userCredentialId) {
	return userCredentialManager.replaceUserCredential(userCredential, userCredentialId);
    }

    @RequestMapping(value = "/usercredentials/{userCredentialId}", produces = { "application/json" })
    public UserCredential getUserCredential(@PathParam("userCredentialId") String userCredentialId) {
	return userCredentialManager.getUserCredential(userCredentialId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/usercredentials/{userCredentialId}", produces = {
	    "application/json" })
    public JsonNode deleteUserCredential(@PathParam("userCredentialId") String userCredentialId) {
	return userCredentialManager.deleteUserCredential(userCredentialId);
    }

    @RequestMapping(value = "/checkusercredentials", produces = { "application/json" })
    public String checkUserCredentials(UserCredential userCredential) {
	return userCredentialManager.checkUserCredential(userCredential);
    }
}