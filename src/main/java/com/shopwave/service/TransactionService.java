package com.shopwave.service;

import com.shopwave.model.Order;
import com.shopwave.model.Seller;
import com.shopwave.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Order order);
    List<Transaction> getTransactionBySeller(Seller seller);
    List<Transaction>getAllTransactions();
}
