package model.operations;

import model.history.Statement;

import java.math.BigDecimal;

public class Deposit extends Operation {

    public Deposit(BigDecimal depositAmount) {
        super(depositAmount);
    }

    @Override
    public BigDecimal execute(Statement statement) {
        return statement.getBalance().add(operationAmount);
    }

    @Override
    public void setOperationType() {
        super.operationType = OperationType.DEPOSIT;
    }
}
