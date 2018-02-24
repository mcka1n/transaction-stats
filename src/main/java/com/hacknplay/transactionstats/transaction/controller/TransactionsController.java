package com.hacknplay.transactionstats.transaction.controller;

import com.hacknplay.transactionstats.transaction.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class TransactionsController {

    @RequestMapping(method = RequestMethod.POST, value = "/transactions")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestParam("amount") Double amount, @RequestParam("timestamp") Long timestamp){
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTimestamp(timestamp);
    }

}
