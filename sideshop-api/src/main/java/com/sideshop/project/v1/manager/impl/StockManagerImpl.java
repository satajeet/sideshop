package com.sideshop.project.v1.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.dao.StockDao;
import com.sideshop.project.v1.entity.Stock;
import com.sideshop.project.v1.manager.StockManager;

@Service
public class StockManagerImpl implements StockManager {

    @Autowired
    StockDao stockDao;

    @Override
    public List<Stock> getAllStocks() {
	Iterable<Stock> stocks = stockDao.findAll();
	List<Stock> stocksList = new ArrayList<>();
	stocks.forEach(stocksList::add);
	return stocksList;
    }

    @Override
    public Stock createStock(Stock stock) {
	return stockDao.save(stock);
    }

    @Override
    public Stock replaceStock(Stock stock, String stockId) {
	stock.setStockId(stockId);
	return stockDao.save(stock);
    }

    @Override
    public Stock getStock(String stockId) {
	return stockDao.findById(stockId).get();
    }

    @Override
    public JsonNode deleteStock(String stockId) {
	stockDao.deleteById(stockId);
	return SideshopConstants.OBJECTMAPPER.createObjectNode();
    }
}
