package com.support.test.service;

import com.support.test.dao.CustomerAccountDao;
import com.support.test.dao.TransactionDao;
import com.support.test.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;

public class TransactionServiceImpl implements TransactionService {
    private final TransactionDao transactionDao;
    private final CustomerAccountDao customerAccountDao;

    @Autowired
    public TransactionServiceImpl(TransactionDao transactionDao, CustomerAccountDao customerAccountDao){
        this.transactionDao = transactionDao;
        this.customerAccountDao = customerAccountDao;
    }

    @Override
    public Page<Transaction> getTransactionsByCustomId(Integer id, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Transaction> getTransactionsBetweenTwoDates(LocalDate localDateStart, LocalDate localDateEnd, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Transaction> getTransactionsBetweenTwoDatesAndByCustomId(LocalDate localDateStart, LocalDate localDateEnd, Integer id, PageRequest pageRequest) {
        return null;
    }

    @Override
    public void addTransaction(Transaction transaction) {

    }
}
