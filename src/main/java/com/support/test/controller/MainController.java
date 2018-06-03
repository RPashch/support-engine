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
        model.addAttribute("customer", new Customer());
        return new ModelAndView("home", model);
    }

}
