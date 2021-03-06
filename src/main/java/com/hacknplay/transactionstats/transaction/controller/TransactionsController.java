package com.hacknplay.transactionstats.transaction.controller;

import com.hacknplay.transactionstats.transaction.model.Transaction;
import com.hacknplay.transactionstats.transaction.repository.TransactionRepository;
import com.hacknplay.transactionstats.transaction.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class TransactionsController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(method = RequestMethod.POST, value = "/transactions")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(Transaction transaction){
        this.transactionRepository.save(transaction);
        statisticService.addTransaction(transaction.getAmount(), transaction.getTimestamp());
    }

}
