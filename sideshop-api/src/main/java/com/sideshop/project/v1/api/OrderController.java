package com.sideshop.project.v1.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sideshop.project.v1.entity.Stock;
import com.sideshop.project.v1.manager.StockManager;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	StockManager stockManager;

	@RequestMapping(value = "/orders", produces = { "application/json" }, consumes = { "application/json" })
	public List<Stock> createOrder() {
		return stockManager.getAllStocks();
	}

}