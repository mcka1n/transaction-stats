package com.hacknplay.transactionstats.transaction.model;

import javax.persistence.*;


@Entity
@Table
public class Transaction {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Double amount;
    @Column
    private Long timestamp;

    public Transaction(final Double amount, final Long timestamp) {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Double getAmount(){
        return amount;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }

    public Long getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(Long timestamp){
        this.timestamp = timestamp;
    }
}
