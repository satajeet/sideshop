package com.sideshop.project.v1.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.Shop;

public interface ShopService {

    public List<Shop> getAllShops();

    public Shop createShop(Shop shop);

    public Shop replaceShop(Shop shop, String shopId);

    public Shop getShop(String shopId);

    public JsonNode deleteShop(String shopId);

    public Shop createShopException(Shop shop);

}
