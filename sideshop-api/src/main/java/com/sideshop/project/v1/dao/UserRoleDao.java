package com.sideshop.project.v1.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sideshop.project.v1.entity.UserRole;

public interface UserRoleDao extends MongoRepository<UserRole, String> {

}
