package com.support.test.service;


import com.support.test.dao.CustomerDao;
import com.support.test.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    @Override
    public Page<Customer> getCustomers(PageRequest pageRequest) {
        return customerDao.findAll(pageRequest);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public Customer getCustomerById(Integer customId) {
        return customerDao.findById(customId).get();
    }

    @Override
    public void updateCustomer(Customer customer) {
        Optional <Customer> customerUpd = customerDao.findById(customer.getId());
        if(customerUpd.isPresent()){
            customerUpd.get().setFirstName(customer.getFirstName());
            customerUpd.get().setSecondName(customer.getSecondName());
            customerDao.save(customerUpd.get());
        }
    }

}
