package com.KataBankAccount.services;

import com.KataBankAccount.domain.Account;

public interface IAccount {
    public void deposit(double amount, Account account);
    public void withdrawal(double amount, Account account);
    public void print();
}

