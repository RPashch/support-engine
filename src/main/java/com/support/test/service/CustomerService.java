package com.support.test.service;

import com.support.test.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerService {

    Page <Customer> getCustomers(PageRequest pageRequest);

    void addCustomer(Customer customer);

    Customer getCustomerById(Integer customId);

    void updateCustomer(Customer customer);

}
