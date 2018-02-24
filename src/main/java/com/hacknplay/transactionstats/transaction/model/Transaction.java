package com.hacknplay.transactionstats.transaction.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;
    private Double amount;
    private Long timestamp;
}
