package com.anz.bankaccount.webservices.anz_api.account;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private static List<Account> accounts = new ArrayList<>();
    private static int idCounter = 0;

    static {
        accounts.add(new Account(++idCounter, "My everyday", "Everyday", "Active", 220 ));
        accounts.add(new Account(++idCounter, "Vineeth Savings", "Savings", "Active", 42000 ));
        accounts.add(new Account(++idCounter, "Test Savings", "Savings", "Pending", 0 ));
    }

    public List<Account> findAll() {
        return accounts;
    }

    public Account createAccount(Account account) {
        account.setId(++idCounter);
        account.setStatus("Pending");
        accounts.add(account);

        return account;
    }
}
