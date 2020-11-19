package com.KataBankAccount.services;

import com.KataBankAccount.domain.Account;
import com.KataBankAccount.domain.Statement;
import com.KataBankAccount.domain.Transaction;
import com.KataBankAccount.domain.TransactionType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountService  implements IAccount {
    List<Statement> history= new ArrayList<>();
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
        addToHistory(type, Math.abs(amount), account);

    }
    private void addToHistory(TransactionType type, double value, Account account) {
        Transaction operation = new Transaction(type, new Date(), value);
        Statement statement = new Statement(operation, account.getBalance());
        history.add(statement);
    }
    @Override
    public void print() {
        history.forEach( statement->System.out.format("%s %s %s %s\n",
                statement.getOperation().getType(),
                statement.getOperation().getDate(),
                statement.getOperation().getAmount(),
                statement.getCurrentBalance()));
    }

}