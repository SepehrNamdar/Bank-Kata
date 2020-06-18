package use_case;

import model.account.Account;
import model.account.Amount;
import model.operations.NegativeOrZeroOperationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.math.BigDecimal.*;
import static java.time.LocalDateTime.now;
import static model.account.Account.aNewAccount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AccountWithdrawalShould {
    private Account account;
    private Amount withdrawalAmount;

    @BeforeEach
    public void init() {
        account = aNewAccount(new Amount(10));
        withdrawalAmount = new Amount(1.25);
    }

    @Test
    void decrease_balance() {
        account.withdrawal(withdrawalAmount, now());

        assertThat(account.getBalance()).isEqualTo(new Amount(8.75));
    }

    @Test
    void be_refused_for_a_negative_amount() {
        assertThatExceptionOfType(NegativeOrZeroOperationException.class)
                .isThrownBy(() -> account.withdrawal(new Amount(-10), now()));
    }

    @Test
    void be_refused_for_a_zero_amount() {
        assertThatExceptionOfType(NegativeOrZeroOperationException.class)
                .isThrownBy(() -> account.withdrawal(new Amount(0), now()));
    }
}
