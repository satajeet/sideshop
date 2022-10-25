package com.sideshop.project.v1.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.Stock;

public interface StockService {

	public List<Stock> getAllStocks();

	public Stock createStock(Stock stock);

	public Stock replaceStock(Stock stock, String stockId);

	public Stock getStock(String stockId);

	public JsonNode deleteStock(String stockId);

}
