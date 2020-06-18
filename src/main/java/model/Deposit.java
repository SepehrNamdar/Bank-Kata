package model;

import java.math.BigDecimal;

import static model.OperationType.DEPOSIT;

class Deposit extends Operation {

    public Deposit(BigDecimal depositAmount) {
        super(depositAmount);
    }

    @Override
    public BigDecimal execute(Statement statement) {
        return statement.getBalance().add(operationAmount);
    }

    @Override
    public void setOperationType() {
        super.operationType = DEPOSIT;
    }
}
