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
    void print() {
        Account account = new Account(TEN, new ArrayList<>());
        BigDecimal depositAmount = valueOf(1.25);

        account.deposit(depositAmount, now);

        List<Statement> expected = new ArrayList<>();
        expected.add(new Statement(TEN, new Deposit(depositAmount), now));

        assertThat(account.getOperationsHistory()).isEqualTo(expected);
    }
}
