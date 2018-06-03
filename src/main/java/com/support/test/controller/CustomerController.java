package com.support.test.controller;

import com.support.test.model.Customer;
import com.support.test.model.CustomerAccount;
import com.support.test.service.CustomerAccountService;
import com.support.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerAccountService customerAccountService;

    @GetMapping(value = "/customer/{id}")
    public ModelAndView getCustomerData(@PathVariable ("id") Integer id, ModelMap modelMap){

        Page <CustomerAccount> page = customerAccountService.getCustomAccountsByCustomId(id, PageRequest.of(0,10));
        if (page.getTotalElements() % 10 == 0)
            modelMap.addAttribute("total", page.getTotalElements() / 10);
        else
            modelMap.addAttribute("total", (page.getTotalElements() / 10) + 1);
        modelMap.addAttribute("customerId",id);
        modelMap.addAttribute("accounts",page);
        modelMap.addAttribute("newAccount", new CustomerAccount());
        return new ModelAndView("customer", modelMap);
    }

    @PostMapping(value = "/customer")
    public String addNewCustomer(@ModelAttribute("customer") Customer customer, BindingResult bindingResult){

        customerService.addCustomer(customer);
        return "redirect:/home";
    }

    @PostMapping(value = "/{customerId}/account")
    public String addNewAccount(@PathVariable ("customerId") Integer customerId, @ModelAttribute("newAccount") CustomerAccount customerAccount, BindingResult bindingResult){

        customerAccount.setCustomer(customerService.getCustomerById(customerId));
        customerAccountService.addCustomAccount(customerAccount);
        return "redirect:/customer/" + customerId;
    }
}
