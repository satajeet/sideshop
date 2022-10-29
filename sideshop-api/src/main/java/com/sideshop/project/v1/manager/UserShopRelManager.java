package com.sideshop.project.v1.manager;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.UserShopRel;

public interface UserShopRelManager {

	public List<UserShopRel> getAllUserShopRels();

	public UserShopRel createUserShopRel(UserShopRel userShopRel);

	public UserShopRel replaceUserShopRel(UserShopRel userShopRel, String userShopRelId);

	public UserShopRel getUserShopRel(String userShopRelId);

	public JsonNode deleteUserShopRel(String userShopRelId);

}
