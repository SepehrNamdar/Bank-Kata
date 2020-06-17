package model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class Account {
    private BigDecimal balance;

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal depositAmount) {
        if (depositAmount.compareTo(ZERO) > 0) {
            balance = balance.add(depositAmount);
        } else {
            throw new NegativeOrZeroOperationException();
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
