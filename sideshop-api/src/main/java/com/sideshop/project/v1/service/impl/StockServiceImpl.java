package com.sideshop.project.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.entity.Stock;
import com.sideshop.project.v1.manager.StockManager;
import com.sideshop.project.v1.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockManager stockManager;

	@Override
	public List<Stock> getAllStocks() {
		return stockManager.getAllStocks();
	}

	@Override
	public Stock createStock(Stock stock) {
		return stockManager.createStock(stock);
	}

	@Override
	public Stock replaceStock(Stock stock, String stockId) {
		return stockManager.replaceStock(stock, stockId);
	}

	@Override
	public Stock getStock(String stockId) {
		return stockManager.getStock(stockId);
	}

	@Override
	public JsonNode deleteStock(String stockId) {
		stockManager.deleteStock(stockId);
		return SideshopConstants.OBJECTMAPPER.createObjectNode();
	}
}
