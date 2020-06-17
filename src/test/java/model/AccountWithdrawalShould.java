package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AccountWithdrawalShould {
    private Account account;
    private BigDecimal withdrawalAmount;

    @BeforeEach
    public void init() {
        account = new Account(TEN);
        withdrawalAmount = valueOf(1.25);
    }

    @Test
    void decrease_balance() {
        account.withdrawal(withdrawalAmount);

        assertThat(account.getBalance()).isEqualTo(TEN.subtract(withdrawalAmount));
    }

    @Test
    void be_refused_for_a_negative_amount() {
        assertThatExceptionOfType(NegativeOrZeroOperationException.class)
                .isThrownBy(() -> account.withdrawal(withdrawalAmount.negate()));
    }

    @Test
    void be_refused_for_a_zero_amount() {
        assertThatExceptionOfType(NegativeOrZeroOperationException.class)
                .isThrownBy(() -> account.withdrawal(ZERO));
    }
}
