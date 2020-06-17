package model;

import java.math.BigDecimal;

public class Deposit extends Operation {

    public Deposit(BigDecimal depositAmount) {
        super(depositAmount);
    }

    @Override
    public BigDecimal execute(BigDecimal balance) {
        return balance.add(operationAmount);
    }
}
