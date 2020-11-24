package account;

import com.KataBankAccount.domain.Account;

import com.KataBankAccount.domain.Statement;
import com.KataBankAccount.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
        double result=account.getBalance();

        //ASSERT
        assertThat(oldBalance-result).isEqualTo(1000);
    }

}