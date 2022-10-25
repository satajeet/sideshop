package com.sideshop.project.v1.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.TransactionRec;

public interface TransactionRecService {

	public List<TransactionRec> getAllTransactions();

	public TransactionRec createTransaction(TransactionRec transactionRec);

	public TransactionRec replaceTransaction(TransactionRec transactionRec, String transactionId);

	public TransactionRec getTransaction(String transactionId);

	public JsonNode deleteTransaction(String transactionId);

}
