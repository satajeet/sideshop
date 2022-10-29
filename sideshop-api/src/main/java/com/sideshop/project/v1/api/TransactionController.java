package com.sideshop.project.v1.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.sideshop.project.v1.entity.TransactionRec;
import com.sideshop.project.v1.manager.TransactionRecManager;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

	@Autowired
	TransactionRecManager transactionRecManager;

	@RequestMapping(value = "/transactions", produces = { "application/json" })
	public List<TransactionRec> getTransactions() {
		return transactionRecManager.getAllTransactions();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/transaction", produces = { "application/json" }, consumes = {
			"application/json" })
	public TransactionRec createTransaction(@RequestBody TransactionRec transactionRec) {
		return transactionRecManager.createTransaction(transactionRec);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/transaction/{transactionReferenceId}", produces = {
			"application/json" }, consumes = { "application/json" })
	public TransactionRec updateTransaction(@RequestBody TransactionRec transactionRec,
			@PathVariable("transactionReferenceId") String transactionId) {
		return transactionRecManager.replaceTransaction(transactionRec, transactionId);
	}

	@RequestMapping(value = "/transaction/{transactionReferenceId}", produces = { "application/json" })
	public TransactionRec getTransaction(@PathVariable("transactionReferenceId") String transactionId) {
		return transactionRecManager.getTransaction(transactionId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/transaction/{transactionReferenceId}", produces = {
			"application/json" })
	public JsonNode deleteTransaction(@PathVariable("transactionReferenceId") String transactionId) {
		return transactionRecManager.deleteTransaction(transactionId);
	}
}