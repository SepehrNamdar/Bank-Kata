package model.history;

import model.account.Amount;
import model.operations.Operation;

import java.time.LocalDateTime;
import java.util.Objects;

public class Statement {

    private final Amount balance;
    private final Operation operation;
    private final LocalDateTime operationDate;

    public Statement(Amount balance, Operation operation, LocalDateTime operationDate) {
        this.balance = balance;
        this.operation = operation;
        this.operationDate = operationDate;
    }

    public Amount getBalance() {
        return balance;
    }

    public Operation getOperation() {
        return operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Objects.equals(balance, statement.balance) &&
                Objects.equals(operation, statement.operation) &&
                Objects.equals(operationDate, statement.operationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, operation, operationDate);
    }
}
