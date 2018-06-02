package com.support.test.dao;

import com.support.test.model.CustomerAccount;
import com.support.test.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TransactionDao extends JpaRepository<Transaction,Integer> {

    Page <Transaction> findAllByAccountFromOrAccountTo(CustomerAccount customerAccountFrom,CustomerAccount customerAccountTo, Pageable pageable);

    Page <Transaction> findAllByDateBetween(LocalDate start, LocalDate end, Pageable pageable);

    Page <Transaction> findAllByAccountFromOrAccountToAndDateBetween(CustomerAccount customerAccountFrom,CustomerAccount customerAccountTo,
                                                                     LocalDate start, LocalDate end, Pageable pageable);
}
