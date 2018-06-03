package com.support.test.service;
import com.support.test.dto.TransactionDTO;
import com.support.test.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface TransactionService {

    Page <Transaction> getAllTransactions(PageRequest pageRequest);

    Page <Transaction> getTransactionsByCustomerAccountId(Integer id, PageRequest pageRequest);

    Page <Transaction> getTransactionsBetweenTwoDates(LocalDate localDateStart, LocalDate localDateEnd, PageRequest pageRequest);

    Page <Transaction> getTransactionsBetweenTwoDatesAndByCustomerAccountId(
            LocalDate localDateStart, LocalDate localDateEnd, Integer id, PageRequest pageRequest);

    void addTransaction(TransactionDTO transactionDTO);

}
