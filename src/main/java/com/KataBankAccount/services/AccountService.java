package com.KataBankAccount.services;

import com.KataBankAccount.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService  implements IAccount {

    public void deposit(double amount, Account account) throws IllegalArgumentException{
        if (amount<0)
        { throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");}
        double result=account.getBalance();
        account.setBalance(result+amount);
    }
    public void withdrawal(double amount, Account account) throws IllegalArgumentException{
        if (amount<0)
        { throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");}
        double result=account.getBalance();
        account.setBalance(Math.abs(result-amount));
    }

}