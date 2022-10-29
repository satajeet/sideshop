package com.sideshop.project.v1.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sideshop.project.v1.dao.StockDao;
import com.sideshop.project.v1.entity.Stock;

@Service
public class StockValidator {

	@Autowired
	StockDao stockDao;

	public boolean validateStockId(String stockId) {
		Optional<Stock> stock = stockDao.findById(stockId);
		return stock.isPresent();
	}
}
