package model;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(operationAmount, operation.operationAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationAmount);
    }
}
