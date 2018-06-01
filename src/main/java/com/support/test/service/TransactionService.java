package com.support.test.service;
import com.support.test.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public interface TransactionService {

    Page <Transaction> getTransactionsByCustomId(Integer id, PageRequest pageRequest);

    Page <Transaction> getTransactionsBetweenTwoDates(LocalDate localDateStart, LocalDate localDateEnd, PageRequest pageRequest);

    Page <Transaction> getTransactionsBetweenTwoDatesAndByCustomId(
            LocalDate localDateStart, LocalDate localDateEnd, Integer id, PageRequest pageRequest);

    void addTransaction(Transaction transaction);

}
