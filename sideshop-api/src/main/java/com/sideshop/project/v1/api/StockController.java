package com.sideshop.project.v1.api;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.Stock;
import com.sideshop.project.v1.manager.StockManager;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    StockManager stockManager;

    @RequestMapping(value = "/stocks", produces = { "application/json" })
    public List<Stock> getStocks() {
	return stockManager.getAllStocks();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/stock", produces = { "application/json" }, consumes = {
	    "application/json" })
    public Stock createStock(@RequestBody Stock stock) {
	return stockManager.createStock(stock);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/stock/{stockId}", produces = {
	    "application/json" }, consumes = { "application/json" })
    public Stock updateStock(@RequestBody Stock stock, @PathParam("stockId") String stockId) {
	return stockManager.replaceStock(stock, stockId);
    }

    @RequestMapping(value = "/stock/{stockId}", produces = { "application/json" })
    public Stock getStock(@PathParam("stockId") String stockId) {
	return stockManager.getStock(stockId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/stock/{stockId}", produces = { "application/json" })
    public JsonNode deleteStock(@PathParam("stockId") String stockId) {
	return stockManager.deleteStock(stockId);
    }
}