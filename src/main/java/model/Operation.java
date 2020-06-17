package model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

abstract class Operation {

    protected final BigDecimal operationAmount;

    public Operation(BigDecimal operationAmount) {
        if (operationAmount.compareTo(ZERO) <= 0) {
            throw new NegativeOrZeroOperationException();
        }

        this.operationAmount = operationAmount;
    }

    public abstract BigDecimal execute(Statement statement);
}
