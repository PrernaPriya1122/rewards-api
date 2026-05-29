package com.rewards.api.model;

import java.time.LocalDate;

/**
 * Represents customer transaction details.
 */
public class Transaction {

    private Long customerId;
    private String customerName;
    private double amount;
    private LocalDate transactionDate;

    public Transaction(Long customerId, String customerName, double amount, LocalDate transactionDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}
