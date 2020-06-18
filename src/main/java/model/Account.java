package model;

import model.history.Statement;
import model.operations.Deposit;
import model.operations.Operation;
import model.operations.Withdrawal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private BigDecimal balance;
    private final List<Statement> operationsHistory;

    public Account(BigDecimal balance) {
        this.balance = balance;
        this.operationsHistory = new ArrayList<>();
    }

    public Account(ArrayList<Statement> previousOperations) {
        this.operationsHistory = previousOperations;
        apply(previousOperations);
    }

    private void apply(ArrayList<Statement> previousOperations) {
        previousOperations.forEach(o -> {
            Operation operation = o.getOperation();
            balance = operation.execute(o);
        });
    }

    public void deposit(BigDecimal depositAmount, LocalDateTime depositDate) {
        Operation deposit = new Deposit(depositAmount);
        Statement statement = new Statement(balance, deposit, depositDate);
        operationsHistory.add(statement);
        balance = deposit.execute(statement);
    }

    public void withdrawal(BigDecimal withdrawalAmount, LocalDateTime withdrawalDate) {
        Operation withdrawal = new Withdrawal(withdrawalAmount);
        Statement statement = new Statement(balance, withdrawal, withdrawalDate);
        operationsHistory.add(statement);
        balance = withdrawal.execute(statement);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Statement> getOperationsHistory() {
        return operationsHistory;
    }
}
