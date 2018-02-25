package com.hacknplay.transactionstats.transaction.repository;

import com.hacknplay.transactionstats.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}