package model;

import java.math.BigDecimal;

class Deposit extends Operation {

    public Deposit(BigDecimal depositAmount) {
        super(depositAmount);
    }

    @Override
    public BigDecimal execute(Statement statement) {
        return statement.getBalance().add(operationAmount);
    }
}
