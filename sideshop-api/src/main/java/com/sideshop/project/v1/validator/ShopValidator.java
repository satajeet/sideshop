package com.sideshop.project.v1.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sideshop.project.v1.dao.ShopDao;
import com.sideshop.project.v1.entity.Shop;

@Service
public class ShopValidator {

	@Autowired
	ShopDao shopDao;

	public boolean validateShopId(String shopId) {
		Optional<Shop> shop = shopDao.findById(shopId);
		return shop.isPresent();
	}
}
