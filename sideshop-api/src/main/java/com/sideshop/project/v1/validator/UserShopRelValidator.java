package com.sideshop.project.v1.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sideshop.project.v1.dao.UserShopRelDao;
import com.sideshop.project.v1.entity.UserShopRel;

@Service
public class UserShopRelValidator {

	@Autowired
	UserShopRelDao userShopRelDao;

	public boolean validateUserShopRelId(String userShopRelId) {
		Optional<UserShopRel> userShopRel = userShopRelDao.findById(userShopRelId);
		return userShopRel.isPresent();
	}
}
