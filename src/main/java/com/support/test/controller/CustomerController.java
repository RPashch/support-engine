package com.support.test.controller;

import com.support.test.model.CustomerAccount;
import com.support.test.service.CustomerAccountService;
import com.support.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        modelMap.addAttribute("accounts",page);
        return new ModelAndView("customer", modelMap);
    }
}
