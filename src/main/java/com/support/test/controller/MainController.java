package com.support.test.controller;

import com.support.test.model.Customer;
import com.support.test.model.CustomerAccount;
import com.support.test.model.Transaction;
import com.support.test.service.CustomerAccountService;
import com.support.test.service.CustomerService;
import com.support.test.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class MainController {

    @Autowired
    CustomerAccountService customerAccountService;
    @Autowired
    CustomerService customerService;
    @Autowired
    TransactionService transactionService;

    @GetMapping(value = {"/","/home"})
    public ModelAndView mainPage(ModelMap model) {
        Page<Customer> page = customerService.getCustomers(PageRequest.of(0,10));
        if (page.getTotalElements() % 10 == 0)
            model.addAttribute("totalCustomers", page.getTotalElements() / 10);
        else
            model.addAttribute("totalCustomers", (page.getTotalElements() / 10) + 1);

        model.addAttribute("customers", page);
        return new ModelAndView("home", model);
    }

    @GetMapping(value = {"/data"})
    public ModelAndView makeData(ModelMap model) {
        Customer customer = Customer.builder().firstName("Vova").secondName("Rara").dateOfBirth(LocalDate.of(1999,12,10)).build();
        customerService.addCustomer(customer);

        Customer customerScnd = Customer.builder().firstName("Roma").secondName("VVVAaaaaa").dateOfBirth(LocalDate.of(1949,1,10)).build();
        customerService.addCustomer(customerScnd);

        CustomerAccount customerAccount3 = CustomerAccount.builder().customer(customer).balance(200.5).build();
        CustomerAccount customerAccount1 = CustomerAccount.builder().customer(customerScnd).balance(100.0).build();
        CustomerAccount customerAccount2 = CustomerAccount.builder().customer(customerScnd).balance(20.5).build();
        customerAccountService.addCustomAccount(customerAccount3);
        customerAccountService.addCustomAccount(customerAccount2);
        customerAccountService.addCustomAccount(customerAccount1);

        Transaction transaction = Transaction.builder().accountFrom(customerAccount1).accountTo(customerAccount2).amount(10.0).date(LocalDate.now()).build();
        transactionService.addTransaction(transaction);

        return new ModelAndView("home", model);
    }
}
