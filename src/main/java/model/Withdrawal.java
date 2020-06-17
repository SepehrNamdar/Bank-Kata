package model;

import java.math.BigDecimal;

public class Withdrawal extends Operation {

    public Withdrawal(BigDecimal withdrawalAmount) {
        super(withdrawalAmount);
    }

    @Override
    public BigDecimal execute(BigDecimal balance) {
        return balance.subtract(this.operationAmount);
    }
}
