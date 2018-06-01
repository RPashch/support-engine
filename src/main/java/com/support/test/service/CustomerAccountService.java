package com.support.test.service;

import com.support.test.model.CustomerAccount;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface CustomerAccountService {

    void updateCustomAccount(CustomerAccount customAccount);

    Page<CustomerAccount> getCustomAccountsByCustomId(Integer id);

    void addCustomAccount(CustomerAccount customAccount);
}
