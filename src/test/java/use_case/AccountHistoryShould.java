package use_case;

import model.Account;
import model.operations.Deposit;
import model.history.Statement;
import model.operations.Withdrawal;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDateTime.now;
import static java.util.Collections.singletonList;
import static model.Account.aNewAccount;
import static model.Account.anExistingAccount;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountHistoryShould {

    private final LocalDateTime now = now();

    @Test
    void print_a_new_account() {
        Account account = aNewAccount(TEN);
        BigDecimal depositAmount = valueOf(1.25);
        BigDecimal withdrawalAmount = valueOf(2.99);

        account.deposit(depositAmount, now);
        account.withdrawal(withdrawalAmount, now);

        List<Statement> expected = new ArrayList<>();
        expected.add(new Statement(TEN, new Deposit(depositAmount), now));
        expected.add(new Statement(valueOf(11.25), new Withdrawal(withdrawalAmount), now));
        assertThat(account.getOperationsHistory()).isEqualTo(expected);
    }

    @Test
    public void print_an_existing_account() {
        BigDecimal withdrawalAmount = valueOf(2.99);
        ArrayList<Statement> previousOperations = new ArrayList<>();
        Statement existingStatement = new Statement(TEN, new Withdrawal(withdrawalAmount), now);
        previousOperations.add(existingStatement);

        Account account = anExistingAccount(previousOperations);

        assertThat(account.getBalance()).isEqualTo(valueOf(7.01));
        List<Statement> expected = singletonList(existingStatement);
        assertThat(account.getOperationsHistory()).isEqualTo(expected);
    }

    @Test
    public void print_an_existing_account_with_new_operations() {
        BigDecimal depositAmount = valueOf(1.25);
        BigDecimal withdrawalAmount = valueOf(2.99);
        ArrayList<Statement> previousOperations = new ArrayList<>();
        Statement existingStatement = new Statement(TEN, new Withdrawal(withdrawalAmount), now);
        previousOperations.add(existingStatement);
        Account account = anExistingAccount(previousOperations);

        account.deposit(depositAmount, now);
        account.withdrawal(withdrawalAmount, now);

        assertThat(account.getBalance()).isEqualTo(valueOf(5.27));
        List<Statement> expected = new ArrayList<>();
        expected.add(existingStatement);
        expected.add(new Statement(valueOf(7.01), new Deposit(depositAmount), now));
        expected.add(new Statement(valueOf(8.26), new Withdrawal(withdrawalAmount), now));
        assertThat(account.getOperationsHistory()).isEqualTo(expected);
    }
}
