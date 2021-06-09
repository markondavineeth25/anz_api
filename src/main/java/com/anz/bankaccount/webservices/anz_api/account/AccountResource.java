package com.anz.bankaccount.webservices.anz_api.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/accounts/listaccounts")
    public List<Account> getAllAccounts(){
        return accountService.findAll();
    }

    @GetMapping("/accounts/{id}/listtransactions")
    public List<Transaction> getAllTransactionsForAccount(@PathVariable long id){
        System.out.println("get all transactions");
        List<Transaction> allTransactionsForAccount = transactionService.getAllTransactionsForAccount(id);
        return allTransactionsForAccount;
    }

    @PostMapping("/accounts/newAccount")
    public ResponseEntity<Void> createAccount(@RequestBody Account account){

        System.out.println("entered create Request:" + account);
        Account createdAccount = accountService.createAccount(account);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdAccount.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}

