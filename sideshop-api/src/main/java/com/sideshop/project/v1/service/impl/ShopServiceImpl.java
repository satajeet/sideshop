package com.sideshop.project.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.entity.Shop;
import com.sideshop.project.v1.manager.ShopManager;
import com.sideshop.project.v1.service.ShopService;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

	@Autowired
	ShopManager shopManager;

	@Override
	public List<Shop> getAllShops() {
		return shopManager.getAllShops();
	}

	@Override
	public Shop createShop(Shop shop) {
		return shopManager.createShop(shop);
	}

	@Override
	public Shop replaceShop(Shop shop, String shopId) {
		shop.setShopId(shopId);
		return shopManager.replaceShop(shop, shopId);
	}

	@Override
	public Shop getShop(String shopId) {
		return shopManager.getShop(shopId);
	}

	@Override
	public JsonNode deleteShop(String shopId) {
		shopManager.deleteShop(shopId);
		return SideshopConstants.OBJECTMAPPER.createObjectNode();
	}

	@Override
	@Transactional
	public Shop createShopException(Shop shop) {
		Shop shop2 = shopManager.createShopException(shop);
		return shop2;
	}

}
