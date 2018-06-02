package com.support.test.service;

import com.support.test.dao.CustomerAccountDao;
import com.support.test.dao.TransactionDao;
import com.support.test.model.CustomerAccount;
import com.support.test.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    private final TransactionDao transactionDao;
    private final CustomerAccountDao customerAccountDao;
    private final CustomerAccountService customerAccountService;

    @Autowired
    public TransactionServiceImpl(TransactionDao transactionDao,
                                  CustomerAccountDao customerAccountDao,CustomerAccountService customerAccountService){
        this.transactionDao = transactionDao;
        this.customerAccountDao = customerAccountDao;
        this.customerAccountService = customerAccountService;
    }

    @Override
    public Page<Transaction> getAllTransactions(PageRequest pageRequest) {
        return transactionDao.findAll(pageRequest);
    }

    @Override
    public Page<Transaction> getTransactionsByCustomerAccountId(Integer id, PageRequest pageRequest) {
        Optional <CustomerAccount> customerAccount = customerAccountDao.findById(id);
        if(customerAccount.isPresent()){
            return transactionDao.findAllByAccountFromOrAccountTo(customerAccount.get(), customerAccount.get(), pageRequest);
        }
        return null;
    }

    @Override
    public Page<Transaction> getTransactionsBetweenTwoDates(LocalDate localDateStart, LocalDate localDateEnd, PageRequest pageRequest) {
        return transactionDao.findAllByDateBetween(localDateStart,localDateEnd,pageRequest);
    }

    @Override
    public Page<Transaction> getTransactionsBetweenTwoDatesAndByCustomerAccountId(
            LocalDate localDateStart, LocalDate localDateEnd, Integer id, PageRequest pageRequest) {
        Optional <CustomerAccount> customerAccount = customerAccountDao.findById(id);
        if(customerAccount.isPresent()) {
            return transactionDao.findAllByAccountFromOrAccountToAndDateBetween(
                    customerAccount.get(), customerAccount.get(),localDateStart,localDateEnd,pageRequest);
        }
        return null;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        customerAccountService.changeBalanceByAccountId(transaction.getAccountFrom().getId(),transaction.getAmount(), false);
        customerAccountService.changeBalanceByAccountId(transaction.getAccountFrom().getId(),transaction.getAmount(), true);
        transactionDao.save(transaction);
    }
}
