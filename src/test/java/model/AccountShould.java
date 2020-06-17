package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class AccountShould {

    @Test
    void increase_balance_after_deposit() {
        Account account = new Account(TEN);
        BigDecimal depositAmount = valueOf(1.25);

        account.deposit(depositAmount);

        assertThat(account.getBalance()).isEqualTo(TEN.add(depositAmount));
    }

    @Test
    void refuse_negative_deposit() {
        Account account = new Account(TEN);
        BigDecimal negativeDepositAmount = valueOf(-1.25);

        assertThatExceptionOfType(NegativeOrZeroOperationException.class)
                .isThrownBy(() -> account.deposit(negativeDepositAmount));
    }

}