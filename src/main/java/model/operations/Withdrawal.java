package model.operations;

import model.history.Statement;

import java.math.BigDecimal;

public class Withdrawal extends Operation {

    public Withdrawal(BigDecimal withdrawalAmount) {
        super(withdrawalAmount);
    }

    @Override
    public BigDecimal execute(Statement statement) {
        return statement.getBalance().subtract(this.operationAmount);
    }

    @Override
    public void setOperationType() {
        super.operationType = OperationType.WITHDRAWAL;
    }
}
