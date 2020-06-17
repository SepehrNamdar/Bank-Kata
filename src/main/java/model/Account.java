package model;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal depositAmount) {
        balance = balance.add(depositAmount);
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
