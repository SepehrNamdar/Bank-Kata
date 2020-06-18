package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountHistoryShould {

    private final LocalDateTime now = now();

    @Test
    void print_a_new_account() {
        Account account = new Account(TEN);
        BigDecimal depositAmount = valueOf(1.25);
        BigDecimal withdrawalAmount = valueOf(2.99);

        account.deposit(depositAmount, now);
        account.withdrawal(withdrawalAmount, now);

        List<Statement> expected = new ArrayList<>();
        expected.add(new Statement(TEN, new Deposit(depositAmount), now));
        expected.add(new Statement(valueOf(11.25), new Withdrawal(withdrawalAmount), now));

        assertThat(account.getOperationsHistory()).isEqualTo(expected);
    }

/*    @Test
    public void print_an_existing_account() {
        BigDecimal withdrawalAmount = valueOf(2.99);
        ArrayList<Statement> previousOperations = new ArrayList<>();
        previousOperations.add(new Statement(TEN, new Withdrawal(withdrawalAmount), now));
        Account account = new Account(TEN, previousOperations);


    }*/
}
