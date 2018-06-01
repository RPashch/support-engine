package com.support.test.service;

import com.support.test.dao.CustomerAccountDao;
import com.support.test.dao.CustomerDao;
import com.support.test.model.CustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class CustomerAccountServiceImpl implements CustomerAccountService {

    private final CustomerAccountDao customerAccountDao;
    private final CustomerDao customerDao;

    @Autowired
    public CustomerAccountServiceImpl(CustomerAccountDao customerAccountDao,CustomerDao customerDao){
        this.customerAccountDao = customerAccountDao;
        this.customerDao = customerDao;
    }

    @Override
    public void updateCustomAccount(CustomerAccount customAccount) {

    }

    @Override
    public Page<CustomerAccount> getCustomAccountsByCustomId(Integer id) {
        return null;
    }

    @Override
    public void addCustomAccount(CustomerAccount customAccount) {
    }
}
