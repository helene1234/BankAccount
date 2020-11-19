package com.KataBankAccount.services;

import com.KataBankAccount.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public void deposit(double amount, Account account) {

        double result=account.getBalance();
        account.setBalance(result+amount);
    }


}