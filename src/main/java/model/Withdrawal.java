package model;

import java.math.BigDecimal;

import static model.OperationType.WITHDRAWAL;

class Withdrawal extends Operation {

    public Withdrawal(BigDecimal withdrawalAmount) {
        super(withdrawalAmount);
    }

    @Override
    public BigDecimal execute(Statement statement) {
        return statement.getBalance().subtract(this.operationAmount);
    }

    @Override
    public void setOperationType() {
        super.operationType = WITHDRAWAL;
    }
}
