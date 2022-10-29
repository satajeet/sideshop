package com.sideshop.project.v1.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sideshop.project.v1.dao.UserDao;
import com.sideshop.project.v1.entity.UserRec;

@Service
public class UserValidator {

	@Autowired
	UserDao userDao;

	public boolean validateUserId(String userId) {
		Optional<UserRec> userRec = userDao.findById(userId);
		return userRec.isPresent();
	}
}
