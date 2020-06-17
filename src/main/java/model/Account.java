package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Account {
    private BigDecimal balance;
    private final List<Statement> operationsHistory;

    public Account(BigDecimal balance, List<Statement> operationsHistory) {
        this.balance = balance;
        this.operationsHistory = operationsHistory;
    }

    public void deposit(BigDecimal depositAmount, LocalDateTime depositDate) {
        Operation deposit = new Deposit(depositAmount);
        Statement statement = new Statement(balance, deposit, depositDate);
        operationsHistory.add(statement);
        balance = deposit.execute(statement);
    }

    public void withdrawal(BigDecimal withdrawalAmount, LocalDateTime withdrawalDate) {
        Operation withdrawal = new Withdrawal(withdrawalAmount);
        balance = withdrawal.execute(new Statement(balance, withdrawal, withdrawalDate));
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Statement> getOperationsHistory() {
        return operationsHistory;
    }
}
