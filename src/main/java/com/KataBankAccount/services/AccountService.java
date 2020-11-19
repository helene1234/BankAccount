package com.KataBankAccount.services;

import com.KataBankAccount.domain.Account;
import com.KataBankAccount.domain.TransactionType;
import org.springframework.stereotype.Service;

@Service
public class AccountService  implements IAccount {
    @Override
    public void deposit(double amount, Account account) throws IllegalArgumentException {
        if (amount<0)
        { throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");}
        makeOperation(TransactionType.DEPOSIT, amount, account);

    }
    @Override
    public void withdrawal(double amount, Account account) throws IllegalArgumentException {
        if (amount<0)
        { throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");}
        makeOperation(TransactionType.WITHDRAWAL, -amount, account);
    }

    private void makeOperation(TransactionType type, double amount, Account account) {
        double result=account.getBalance();
        account.setBalance(result+amount);

    }
}