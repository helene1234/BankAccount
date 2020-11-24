package com.KataBankAccount;

import com.KataBankAccount.domain.Account;
import com.KataBankAccount.domain.Statement;
import com.KataBankAccount.services.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class KataBankAccountApplicationTests {
  AccountService accountService =new AccountService();
  Account account = new Account(1L, 0, new ArrayList<Statement>());

  @Test
  public void when_make_three_transactions_then_size_history_account_should_equals_three() {

   // ACT
    accountService.deposit(1000, account);
    accountService.withdrawal(500, account);
    accountService.deposit(300, account);

    //ASSERT
    assertEquals(account.getHistory().size(), 3);
  }

}
