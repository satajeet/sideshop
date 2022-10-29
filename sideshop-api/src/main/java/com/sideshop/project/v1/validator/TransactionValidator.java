package com.sideshop.project.v1.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sideshop.project.v1.dao.TransactionDao;
import com.sideshop.project.v1.entity.TransactionRec;

@Service
public class TransactionValidator {

	@Autowired
	TransactionDao transactionDao;

	public boolean validateTransactionId(String transactionId) {
		Optional<TransactionRec> transactionRec = transactionDao.findById(transactionId);
		return transactionRec.isPresent();
	}
}
