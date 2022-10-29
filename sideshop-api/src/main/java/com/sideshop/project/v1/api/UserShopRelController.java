package com.sideshop.project.v1.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.UserShopRel;
import com.sideshop.project.v1.manager.UserShopRelManager;

@RestController
@RequestMapping(value = "/usershoprel")
public class UserShopRelController {

	@Autowired
	UserShopRelManager userShopRelManager;

	@RequestMapping(value = "/usershoprels", produces = { "application/json" })
	public List<UserShopRel> getUserShopRels() {
		return userShopRelManager.getAllUserShopRels();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/usershoprel", produces = { "application/json" }, consumes = {
			"application/json" })
	public UserShopRel createUserShopRel(@RequestBody UserShopRel userShopRel) {
		return userShopRelManager.createUserShopRel(userShopRel);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/usershoprel/{userShopRelId}", produces = {
			"application/json" }, consumes = { "application/json" })
	public UserShopRel updateUserShopRel(@RequestBody UserShopRel userShopRel,
			@PathVariable("userShopRelId") String userShopRelId) {
		return userShopRelManager.replaceUserShopRel(userShopRel, userShopRelId);
	}

	@RequestMapping(value = "/usershoprel/{userShopRelId}", produces = { "application/json" })
	public UserShopRel getUserShopRel(@PathVariable("userShopRelId") String userShopRelId) {
		return userShopRelManager.getUserShopRel(userShopRelId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/usershoprel/{userShopRelId}", produces = {
			"application/json" })
	public JsonNode deleteUserShopRel(@PathVariable("userShopRelId") String userShopRelId) {
		return userShopRelManager.deleteUserShopRel(userShopRelId);
	}
}