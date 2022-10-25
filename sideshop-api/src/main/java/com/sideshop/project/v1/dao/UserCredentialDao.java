package com.sideshop.project.v1.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sideshop.project.v1.entity.UserCredential;

public interface UserCredentialDao extends MongoRepository<UserCredential, String> {

}
