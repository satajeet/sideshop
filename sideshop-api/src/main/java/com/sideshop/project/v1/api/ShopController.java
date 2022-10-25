package com.sideshop.project.v1.api;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.Shop;
import com.sideshop.project.v1.manager.ShopManager;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

	@Autowired
	ShopManager shopManager;

	@RequestMapping(value = "/shops", produces = { "application/json" })
	public List<Shop> getShops() {
		return shopManager.getAllShops();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shop", produces = { "application/json" }, consumes = {
			"application/json" })
	public Shop createShop(@RequestBody Shop shop) {
		return shopManager.createShop(shop);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/shop/{shopId}", produces = {
			"application/json" }, consumes = { "application/json" })
	public Shop updateShop(@RequestBody Shop shop, @PathParam("shopId") String shopId) {
		return shopManager.replaceShop(shop, shopId);
	}

	@RequestMapping(value = "/shop/{shopId}", produces = { "application/json" })
	public Shop getShop(@PathParam("shopId") String shopId) {
		return shopManager.getShop(shopId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/shop/{shopId}")
	public JsonNode deleteShop(@PathParam("shopId") String shopId) {
		return shopManager.deleteShop(shopId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shopException", produces = {
			"application/json" }, consumes = { "application/json" })
	public Shop shopException(@RequestBody Shop shop) {
		return shopManager.createShopException(shop);
	}
}