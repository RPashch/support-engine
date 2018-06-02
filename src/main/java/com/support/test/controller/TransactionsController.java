package com.support.test.controller;

import com.support.test.model.Transaction;
import com.support.test.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransactionsController {

    @Autowired
    TransactionService transactionService;

    @GetMapping(value = "/transactions")
    public ModelAndView getTransactions(ModelMap model) {
        Page <Transaction> page = transactionService.getAllTransactions(PageRequest.of(0,10));
        if (page.getTotalElements() % 10 == 0)
            model.addAttribute("total", page.getTotalElements() / 10);
        else
            model.addAttribute("total", (page.getTotalElements() / 10) + 1);

        model.addAttribute("transactionsList", page);
        return new ModelAndView("transactions", model);
    }
}
