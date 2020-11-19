package account;

import com.KataBankAccount.domain.Account;

import com.KataBankAccount.services.AccountService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class bankAccountTest {

       @Test
    public void when_1000_are_deposited_then_account_balance_increases_by_1000() {

         //ARRANGE
        Account account = new Account(1L,0);
        AccountService accountService= new AccountService();

         //ACT
        double oldBalance = account.getBalance();
        accountService.deposit(1000, account);
        double result=account.getBalance();

        //ASSERT
        assertThat(result-oldBalance).isEqualTo(1000);
    }

    }