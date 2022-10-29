package com.sideshop.project.v1.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sideshop.project.v1.entity.UserShopRel;

public interface UserShopRelDao extends MongoRepository<UserShopRel, String> {

}
