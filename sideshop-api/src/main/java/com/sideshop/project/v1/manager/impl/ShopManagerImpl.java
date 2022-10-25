package com.sideshop.project.v1.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.dao.ShopDao;
import com.sideshop.project.v1.entity.Shop;
import com.sideshop.project.v1.exception.SideshopNotfoundException;
import com.sideshop.project.v1.manager.ShopManager;

@Service
@Transactional
public class ShopManagerImpl implements ShopManager {

    @Autowired
    ShopDao shopDao;

    @Override
    public List<Shop> getAllShops() {
	Iterable<Shop> shops = shopDao.findAll();
	List<Shop> shopsList = new ArrayList<>();
	shops.forEach(shopsList::add);
	return shopsList;
    }

    @Override
    public Shop createShop(Shop shop) {
	return shopDao.save(shop);
    }

    @Override
    public Shop replaceShop(Shop shop, String shopId) {
	shop.setShopId(shopId);
	return shopDao.save(shop);
    }

    @Override
    public Shop getShop(String shopId) {
	return shopDao.findById(shopId).get();
    }

    @Override
    public JsonNode deleteShop(String shopId) {
	shopDao.deleteById(shopId);
	return SideshopConstants.OBJECTMAPPER.createObjectNode();
    }

    @Override
    @Transactional
    public Shop createShopException(Shop shop) {
	shopDao.save(shop);
	throw new SideshopNotfoundException();
    }

}
