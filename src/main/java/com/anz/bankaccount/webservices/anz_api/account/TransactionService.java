package com.anz.bankaccount.webservices.anz_api.account;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionService {

    private static List<Transaction> transactions1 = new ArrayList<>();
    private static List<Transaction> transactions2 = new ArrayList<>();
    private static Map<Long, List<Transaction>> transactionMap = new HashMap<>();
    private static int idCounter = 0;

    static {
        prepareTransactions();
    }

    private static Map<Long, List<Transaction>> prepareTransactions() {
        transactions1.add(new Transaction(11, "coffee", 4, new Date(), "Debit"));
        transactions1.add(new Transaction(12, "ebay Purchase Reversal", 22, new Date(), "Credit"));
        transactionMap.put((long) 1, transactions1);

        transactions2.add(new Transaction(21, "home loan emi", 2500, new Date(), "Debit"));
        transactions2.add(new Transaction(22, "Salary credit", 10002, new Date(), "Credit"));
        transactionMap.put((long) 2, transactions2);

        return transactionMap;
    }

    public List<Transaction> getAllTransactionsForAccount(long id) {
        List<Transaction> transactions = transactionMap.entrySet().stream()
                .filter(listEntry -> listEntry.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst()
                .get();
        return transactions;
    }


}
