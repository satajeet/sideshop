package com.sideshop.project.v1.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.dao.TransactionDao;
import com.sideshop.project.v1.entity.TransactionRec;
import com.sideshop.project.v1.manager.TransactionRecManager;

@Service
public class TransactionRecManagerImpl implements TransactionRecManager {

	@Autowired
	TransactionDao transactionDao;

	@Override
	public List<TransactionRec> getAllTransactions() {
		Iterable<TransactionRec> transactions = transactionDao.findAll();
		List<TransactionRec> transactionsList = new ArrayList<>();
		transactions.forEach(transactionsList::add);
		return transactionsList;
	}

	@Override
	public TransactionRec createTransaction(TransactionRec transaction) {
		return transactionDao.save(transaction);
	}

	@Override
	public TransactionRec replaceTransaction(TransactionRec transaction, String transactionId) {
		transaction.setTransactionId(transactionId);
		return transactionDao.save(transaction);
	}

	@Override
	public TransactionRec getTransaction(String transactionId) {
		return transactionDao.findById(transactionId).get();
	}

	@Override
	public JsonNode deleteTransaction(String transactionId) {
		transactionDao.deleteById(transactionId);
		return SideshopConstants.OBJECTMAPPER.createObjectNode();
	}
}
