package com.support.test.service;

import com.support.test.dao.CustomerAccountDao;
import com.support.test.dao.CustomerDao;
import com.support.test.model.CustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class CustomerAccountServiceImpl implements CustomerAccountService {

    private final CustomerAccountDao customerAccountDao;
    private final CustomerDao customerDao;

    @Autowired
    public CustomerAccountServiceImpl(CustomerAccountDao customerAccountDao,CustomerDao customerDao){
        this.customerAccountDao = customerAccountDao;
        this.customerDao = customerDao;
    }

    @Override
    public void updateCustomAccount(CustomerAccount customerAccountOld) {
        Optional <CustomerAccount> customerAccountUpd = customerAccountDao.findById(customerAccountOld.getId());
        if(customerAccountUpd.isPresent()){
            customerAccountUpd.get().setBalance(customerAccountOld.getBalance());
            //the account shouldn't be changed
            //customerAccountUpd.get().setCustomer(customerAccountOld.getCustomer());
            customerAccountDao.save(customerAccountUpd.get());
        }
    }

    @Override
    public Page<CustomerAccount> getCustomAccountsByCustomId(Integer id,PageRequest pageRequest) {
        return customerAccountDao.findCustomerAccountsByCustomer_Id(id,pageRequest);
    }

    @Override
    public void addCustomAccount(CustomerAccount customAccount) {
        customerAccountDao.save(customAccount);
    }

    @Override
    public void changeBalanceByAccountId(Integer id, Double amount, Boolean refill) {

            Optional<CustomerAccount> customerAccountUpd = customerAccountDao.findById(id);
            if (customerAccountUpd.isPresent()) {
                if(refill) {
                    customerAccountUpd.get().setBalance(customerAccountUpd.get().getBalance() + amount);
                }
                else{
                    customerAccountUpd.get().setBalance(customerAccountUpd.get().getBalance() - amount);
                    }
                customerAccountDao.save(customerAccountUpd.get());
            }
    }
}
