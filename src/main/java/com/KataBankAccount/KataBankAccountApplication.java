package com.KataBankAccount;

import com.KataBankAccount.domain.Account;
import com.KataBankAccount.domain.Statement;
import com.KataBankAccount.services.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class KataBankAccountApplication {

    public static void main(String[] args) {
        Account account = new Account(1L, 0, new ArrayList<Statement>());
        AccountService accountService=new AccountService();

        try {
            accountService.deposit(1500,account);
            accountService.deposit(1500,account);
            accountService.withdrawal(1500,account);
            accountService.print();

        } catch (IllegalArgumentException e) {
            System.out.println("Only Positive Numbers & no Letters Please!");
        }
        SpringApplication.run(KataBankAccountApplication.class, args);
    }
}