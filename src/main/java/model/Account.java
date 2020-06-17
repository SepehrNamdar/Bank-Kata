package model;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal depositAmount) {
        Operation deposit = new Deposit(depositAmount);
        balance = deposit.execute(new Statement(balance, deposit));
    }

    public void withdrawal(BigDecimal withdrawalAmount) {
        Operation withdrawal = new Withdrawal(withdrawalAmount);
        balance = withdrawal.execute(new Statement(balance, withdrawal));
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
