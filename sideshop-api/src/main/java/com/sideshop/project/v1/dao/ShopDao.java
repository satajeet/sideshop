package com.sideshop.project.v1.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sideshop.project.v1.entity.Shop;

public interface ShopDao extends MongoRepository<Shop, String> {

}
