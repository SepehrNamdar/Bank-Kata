package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class Statement {

    private final BigDecimal balance;
    private final Operation operation;
    private final LocalDateTime operationDate;

    public Statement(BigDecimal balance, Operation operation) {
        this.balance = balance;
        this.operation = operation;
        this.operationDate = now();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Operation getOperation() {
        return operation;
    }

    public LocalDateTime getOpertionDate() {
        return operationDate;
    }
}
