package com.sideshop.project.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.entity.TransactionRec;
import com.sideshop.project.v1.manager.TransactionRecManager;
import com.sideshop.project.v1.service.TransactionRecService;

@Service
public class TransactionRecServiceImpl implements TransactionRecService {

	@Autowired
	TransactionRecManager transactionRecManager;

	@Override
	public List<TransactionRec> getAllTransactions() {
		return transactionRecManager.getAllTransactions();
	}

	@Override
	public TransactionRec createTransaction(TransactionRec transaction) {
		return transactionRecManager.createTransaction(transaction);
	}

	@Override
	public TransactionRec replaceTransaction(TransactionRec transaction, String transactionId) {
		transaction.setTransactionId(transactionId);
		return transactionRecManager.replaceTransaction(transaction, transactionId);
	}

	@Override
	public TransactionRec getTransaction(String transactionId) {
		return transactionRecManager.getTransaction(transactionId);
	}

	@Override
	public JsonNode deleteTransaction(String transactionId) {
		transactionRecManager.deleteTransaction(transactionId);
		return SideshopConstants.OBJECTMAPPER.createObjectNode();
	}
}
