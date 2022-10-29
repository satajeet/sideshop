package com.sideshop.project.v1.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.constants.SideshopConstants;
import com.sideshop.project.v1.dao.TransactionDao;
import com.sideshop.project.v1.entity.TransactionRec;
import com.sideshop.project.v1.exception.SideshopException;
import com.sideshop.project.v1.manager.TransactionRecManager;
import com.sideshop.project.v1.validator.TransactionValidator;

@Service
@Transactional
public class TransactionRecManagerImpl implements TransactionRecManager {

	@Autowired
	TransactionDao transactionDao;

	@Autowired
	TransactionValidator transactionValidator;

	@Override
	public List<TransactionRec> getAllTransactions() {
		Iterable<TransactionRec> transactions = transactionDao.findAll();
		List<TransactionRec> transactionsList = new ArrayList<>();
		transactions.forEach(transactionsList::add);
		return transactionsList;
	}

	@Override
	@Transactional
	public TransactionRec createTransaction(TransactionRec transactionRec) {
		transactionRec.set_id(UUID.randomUUID().toString());
		return transactionDao.save(transactionRec);
	}

	@Override
	@Transactional
	public TransactionRec replaceTransaction(TransactionRec transactionRec, String transactionId) {
		if (!transactionValidator.validateTransactionId(transactionId)) {
			throw new SideshopException("TransactionId is invalid");
		}
		transactionRec.set_id(transactionId);
		return transactionDao.save(transactionRec);
	}

	@Override
	public TransactionRec getTransaction(String transactionId) {
		if (!transactionValidator.validateTransactionId(transactionId)) {
			throw new SideshopException("TransactionId is invalid");
		}
		return transactionDao.findById(transactionId).get();
	}

	@Override
	@Transactional
	public JsonNode deleteTransaction(String transactionId) {
		if (!transactionValidator.validateTransactionId(transactionId)) {
			throw new SideshopException("TransactionId is invalid");
		}
		transactionDao.deleteById(transactionId);
		return SideshopConstants.OBJECTMAPPER.createObjectNode();
	}
}
