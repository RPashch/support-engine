package com.support.test.service;


import com.support.test.dao.CustomerDao;
import com.support.test.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    @Override
    public Page<Customer> getCustomers(PageRequest pageRequest) {
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void updateCustomerById(Integer customId) {

    }
}
