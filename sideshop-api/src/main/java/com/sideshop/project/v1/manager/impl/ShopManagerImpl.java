package com.sideshop.project.v1.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.dao.ShopDao;
import com.sideshop.project.v1.entity.Shop;
import com.sideshop.project.v1.exception.SideshopException;
import com.sideshop.project.v1.manager.ShopManager;
import com.sideshop.project.v1.validator.ShopValidator;

@Service
@Transactional
public class ShopManagerImpl implements ShopManager {

	@Autowired
	ShopDao shopDao;

	@Autowired
	ShopValidator shopValidator;

	@Override
	public List<Shop> getAllShops() {
		Iterable<Shop> shops = shopDao.findAll();
		List<Shop> shopsList = new ArrayList<>();
		shops.forEach(shopsList::add);
		return shopsList;
	}

	@Override
	@Transactional
	public Shop createShop(Shop shop) {
		shop.set_id(UUID.randomUUID().toString());
		return shopDao.save(shop);
	}

	@Override
	@Transactional
	public Shop replaceShop(Shop shop, String shopId) {
		if (!shopValidator.validateShopId(shopId)) {
			throw new SideshopException("ShopId is invalid");
		}
		shop.set_id(shopId);
		return shopDao.save(shop);
	}

	@Override
	public Shop getShop(String shopId) {
		if (!shopValidator.validateShopId(shopId)) {
			throw new SideshopException("ShopId is invalid");
		}
		return shopDao.findById(shopId).get();
	}

	@Override
	@Transactional
	public JsonNode deleteShop(String shopId) {
		if (!shopValidator.validateShopId(shopId)) {
			throw new SideshopException("ShopId is invalid");
		}
		shopDao.deleteById(shopId);
		return SideshopConstants.OBJECTMAPPER.createObjectNode();
	}

}
