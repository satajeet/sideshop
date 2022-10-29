package com.sideshop.project.v1.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sideshop.project.v1.dao.UserRoleDao;
import com.sideshop.project.v1.entity.UserRole;

@Service
public class UserRoleValidator {

	@Autowired
	UserRoleDao userRoleDao;

	public boolean validateUserRoleId(String userRoleId) {
		Optional<UserRole> userRole = userRoleDao.findById(userRoleId);
		return userRole.isPresent();
	}
}
