package com.support.test.service;

import com.support.test.model.CustomerAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface CustomerAccountService {

    void updateCustomAccount(CustomerAccount customAccount);

    Page<CustomerAccount> getCustomAccountsByCustomId(Integer id, PageRequest pageRequest);

    void addCustomAccount(CustomerAccount customAccount);

    void changeBalanceByAccountId(Integer id, Double amount, Boolean refill);
}
