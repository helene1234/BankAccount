package account;

import com.KataBankAccount.domain.Account;

import com.KataBankAccount.domain.Statement;
import com.KataBankAccount.services.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class bankAccountTest {
     @Autowired
     Account account;
     AccountService accountService=new AccountService();


  @BeforeEach
     public void init() {
     account = new Account(1L, 0, new ArrayList<Statement>());
     }


     @Test
     public void when_1000_are_deposited_then_account_balance_increases_by_1000() throws IllegalArgumentException{

         //ACT
        double oldBalance = account.getBalance();
        accountService.deposit(1000, account);
        double result=account.getBalance();

        //ASSERT
        assertThat(result-oldBalance).isEqualTo(1000);
    }
    @Test
    public void when_1000_are_withdrawed_then_account_balance_decreases_by_1000() throws IllegalArgumentException {

      //ACT
      double oldBalance = account.getBalance();
      accountService.withdrawal(1000, account);
      double result = account.getBalance();

      //ASSERT
      assertThat(oldBalance - result).isEqualTo(1000);
    }

    @Test
    public void when_make_three_transactions_then_size_history_account_should_equals_three() throws IllegalArgumentException {

      // ACT
      accountService.deposit(1000, account);
      accountService.withdrawal(500, account);
      accountService.deposit(300, account);

      //ASSERT
      assertThat(account.getHistory().size()).isEqualTo(3);
    }

    @Test
    public void when_1000_are_deposited_and_500_are_withdrawed_amount_then_account_balance_increases_by_500() throws IllegalArgumentException {
      //ACT
      accountService.deposit(1000, account);
      accountService.withdrawal(500, account);

      //ASSERT
      assertThat(account.getBalance()).isEqualTo(500);

    }
    @Test
    public void when_negative_amount_is_supplied_for_deposit_then_should_throw_exception() throws IllegalArgumentException {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      accountService.deposit(-1000, account);
    });
  }

    @Test
    public void when_negative_amount_is_supplied_for_withdraw_then_should_throw_exception() throws IllegalArgumentException {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      accountService.withdrawal(-1000, account);
    });
  }

  }