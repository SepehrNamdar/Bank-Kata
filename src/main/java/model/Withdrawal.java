package model;

import java.math.BigDecimal;

class Withdrawal extends Operation {

    public Withdrawal(BigDecimal withdrawalAmount) {
        super(withdrawalAmount);
    }

    @Override
    public BigDecimal execute(Statement statement) {
        return statement.getBalance().subtract(this.operationAmount);
    }
}
