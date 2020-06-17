package model;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal depositAmount) {
        Deposit deposit = new Deposit(depositAmount);
        balance = deposit.execute(balance);
    }

    public void withdrawal(BigDecimal withdrawalAmount) {
        Withdrawal withdrawal = new Withdrawal(withdrawalAmount);
        balance = withdrawal.execute(balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
