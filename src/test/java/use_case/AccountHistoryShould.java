package use_case;

import model.account.Account;
import model.account.Amount;
import model.history.History;
import model.operations.Deposit;
import model.history.Statement;
import model.operations.Withdrawal;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static model.account.Account.aNewAccount;
import static model.account.Account.anExistingAccount;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountHistoryShould {

    private final LocalDateTime now = now();

    @Test
    void print_a_new_account() {
        Account account = aNewAccount(new Amount(10));
        Amount depositAmount = new Amount(1.25);
        Amount withdrawalAmount = new Amount(2.99);

        account.deposit(depositAmount, now);
        account.withdrawal(withdrawalAmount, now);

        History expected = new History();
        expected.add(new Statement(new Amount(10), new Deposit(depositAmount), now));
        expected.add(new Statement(new Amount(11.25), new Withdrawal(withdrawalAmount), now));
        assertThat(account.getOperationsHistory()).isEqualTo(expected);
    }

    @Test
    public void print_an_existing_account() {
        Amount withdrawalAmount = new Amount(2.99);
        History previousOperations = new History();
        Statement existingStatement = new Statement(new Amount(10), new Withdrawal(withdrawalAmount), now);
        previousOperations.add(existingStatement);

        Account account = anExistingAccount(previousOperations);

        assertThat(account.getBalance()).isEqualTo(new Amount(7.01));
        History expected = new History();
        expected.add(existingStatement);
        assertThat(account.getOperationsHistory()).isEqualTo(expected);
    }

    @Test
    public void print_an_existing_account_with_new_operations() {
        Amount depositAmount = new Amount(1.25);
        Amount withdrawalAmount = new Amount(2.99);
        History previousOperations = new History();
        Statement existingStatement = new Statement(new Amount(10), new Withdrawal(withdrawalAmount), now);
        previousOperations.add(existingStatement);
        Account account = anExistingAccount(previousOperations);

        account.deposit(depositAmount, now);
        account.withdrawal(withdrawalAmount, now);

        assertThat(account.getBalance()).isEqualTo(new Amount(5.27));
        History expected = new History();
        expected.add(existingStatement);
        expected.add(new Statement(new Amount(7.01), new Deposit(depositAmount), now));
        expected.add(new Statement(new Amount(8.26), new Withdrawal(withdrawalAmount), now));
        assertThat(account.getOperationsHistory()).isEqualTo(expected);
    }
}
