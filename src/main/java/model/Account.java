package model;

import model.history.History;
import model.history.Statement;
import model.operations.Deposit;
import model.operations.Operation;
import model.operations.Withdrawal;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {
    private BigDecimal balance;
    private final History operationsHistory;

    public static Account aNewAccount(BigDecimal balance) {
        return new Account(balance);
    }

    private Account(BigDecimal balance) {
        this.balance = balance;
        this.operationsHistory = new History();
    }

    public static Account anExistingAccount(History previousOperations) {
        return new Account(previousOperations);
    }

    private Account(History previousOperations) {
        this.operationsHistory = previousOperations;
        apply(previousOperations);
    }

    private void apply(History previousOperations) {
        previousOperations.getHistory().forEach(o -> {
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

    public History getOperationsHistory() {
        return operationsHistory;
    }
}
