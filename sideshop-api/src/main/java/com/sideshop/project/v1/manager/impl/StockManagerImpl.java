package com.sideshop.project.v1.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.dao.StockDao;
import com.sideshop.project.v1.entity.Stock;
import com.sideshop.project.v1.exception.SideshopException;
import com.sideshop.project.v1.manager.StockManager;
import com.sideshop.project.v1.validator.ShopValidator;
import com.sideshop.project.v1.validator.StockValidator;

@Service
@Transactional
public class StockManagerImpl implements StockManager {

	@Autowired
	StockDao stockDao;

	@Autowired
	ShopValidator shopValidator;

	@Autowired
	StockValidator stockValidator;

	@Override
	public List<Stock> getAllStocks() {
		Iterable<Stock> stocks = stockDao.findAll();
		List<Stock> stocksList = new ArrayList<>();
		stocks.forEach(stocksList::add);
		return stocksList;
	}

	@Override
	@Transactional
	public Stock createStock(Stock stock) {
		if (!shopValidator.validateShopId(stock.getShopId())) {
			throw new SideshopException("StockId is invalid");
		}
		stock.set_id(UUID.randomUUID().toString());
		return stockDao.save(stock);
	}

	@Override
	@Transactional
	public Stock replaceStock(Stock stock, String stockId) {
		if (!shopValidator.validateShopId(stock.getShopId())) {
			throw new SideshopException("ShopId is invalid");
		}
		if (stockValidator.validateStockId(stockId)) {
			throw new SideshopException("StockId is invalid");
		}
		stock.set_id(stockId);
		return stockDao.save(stock);
	}

	@Override
	public Stock getStock(String stockId) {
		if (!stockValidator.validateStockId(stockId)) {
			throw new SideshopException("StockId is invalid");
		}
		return stockDao.findById(stockId).get();
	}

	@Override
	@Transactional
	public JsonNode deleteStock(String stockId) {
		if (!stockValidator.validateStockId(stockId)) {
			throw new SideshopException("StockId is invalid");
		}
		stockDao.deleteById(stockId);
		return SideshopConstants.OBJECTMAPPER.createObjectNode();
	}
}
