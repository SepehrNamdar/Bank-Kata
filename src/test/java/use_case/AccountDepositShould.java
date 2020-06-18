package use_case;

import model.Account;
import model.operations.NegativeOrZeroOperationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static java.time.LocalDateTime.now;
import static model.Account.aNewAccount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class AccountDepositShould {
    private Account account;
    private BigDecimal depositAmount;

    @BeforeEach
    public void init() {
        account = aNewAccount(TEN);
        depositAmount = valueOf(1.25);
    }

    @Test
    void increase_balance() {
        account.deposit(depositAmount, now());

        assertThat(account.getBalance()).isEqualTo(TEN.add(depositAmount));
    }

    @Test
    void be_refused_for_a_negative_amount() {
        assertThatExceptionOfType(NegativeOrZeroOperationException.class)
                .isThrownBy(() -> account.deposit(depositAmount.negate(), now()));
    }

    @Test
    void be_refused_for_a_zero_amount() {
        assertThatExceptionOfType(NegativeOrZeroOperationException.class)
                .isThrownBy(() -> account.deposit(ZERO, now()));
    }
}