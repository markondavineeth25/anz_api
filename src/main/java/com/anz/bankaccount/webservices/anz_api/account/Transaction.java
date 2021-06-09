package com.anz.bankaccount.webservices.anz_api.account;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Transaction {

    private long transactionId;
    private String description;
    private long transactionAmount;
    private Date transactionDate;
    private String transactionType;

    public Transaction() {
    }

    public Transaction(long transactionId, String description, long transactionAmount, Date transactionDate, String transactionType) {
        this.transactionId = transactionId;
        this.description = description;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }
}
