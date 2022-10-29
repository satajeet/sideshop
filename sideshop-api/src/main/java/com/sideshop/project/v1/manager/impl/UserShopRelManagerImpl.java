package com.sideshop.project.v1.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.dao.UserShopRelDao;
import com.sideshop.project.v1.entity.UserShopRel;
import com.sideshop.project.v1.exception.SideshopException;
import com.sideshop.project.v1.manager.UserShopRelManager;
import com.sideshop.project.v1.validator.ShopValidator;
import com.sideshop.project.v1.validator.UserShopRelValidator;
import com.sideshop.project.v1.validator.UserValidator;

@Service
@Transactional
public class UserShopRelManagerImpl implements UserShopRelManager {

	@Autowired
	UserShopRelDao userShopRelDao;

	@Autowired
	ShopValidator shopValidator;

	@Autowired
	UserValidator userValidator;

	@Autowired
	UserShopRelValidator userShopRelValidator;

	@Override
	public List<UserShopRel> getAllUserShopRels() {
		Iterable<UserShopRel> userShopRels = userShopRelDao.findAll();
		List<UserShopRel> userShopRelList = new ArrayList<>();
		userShopRels.forEach(userShopRelList::add);
		return userShopRelList;
	}

	@Override
	@Transactional
	public UserShopRel createUserShopRel(UserShopRel userShopRel) {
		if (!shopValidator.validateShopId(userShopRel.getShopId())) {
			throw new SideshopException("ShopId is invalid");
		}
		if (!userValidator.validateUserId(userShopRel.getUserId())) {
			throw new SideshopException("UserId is invalid");
		}
		userShopRel.set_id(UUID.randomUUID().toString());
		return userShopRelDao.save(userShopRel);
	}

	@Override
	@Transactional
	public UserShopRel replaceUserShopRel(UserShopRel userShopRel, String userShopRelId) {
		if (!shopValidator.validateShopId(userShopRel.getShopId())) {
			throw new SideshopException("ShopId is invalid");
		}
		if (!userValidator.validateUserId(userShopRel.getUserId())) {
			throw new SideshopException("UserId is invalid");
		}
		if (!userShopRelValidator.validateUserShopRelId(userShopRelId)) {
			throw new SideshopException("UserShopRelId is invalid");
		}
		userShopRel.set_id(userShopRelId);
		return userShopRelDao.save(userShopRel);
	}

	@Override
	public UserShopRel getUserShopRel(String userShopRelId) {
		if (!userShopRelValidator.validateUserShopRelId(userShopRelId)) {
			throw new SideshopException("UserShopRelId is invalid");
		}
		return userShopRelDao.findById(userShopRelId).get();
	}

	@Override
	@Transactional
	public JsonNode deleteUserShopRel(String userShopRelId) {
		if (!userShopRelValidator.validateUserShopRelId(userShopRelId)) {
			throw new SideshopException("UserShopRelId is invalid");
		}
		userShopRelDao.deleteById(userShopRelId);
		return SideshopConstants.OBJECTMAPPER.createObjectNode();
	}

}
