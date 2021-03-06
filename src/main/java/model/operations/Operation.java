package model.operations;

import model.account.Amount;
import model.history.Statement;

import java.util.Objects;

import static java.math.BigDecimal.ZERO;

public abstract class Operation {

    protected final Amount operationAmount;
    protected OperationType operationType = OperationType.UNDEFINED;

    public Operation(Amount operationAmount) {
        if (isNegativeOrZero(operationAmount)) {
            throw new NegativeOrZeroOperationException();
        }

        this.operationAmount = operationAmount;
    }

    private boolean isNegativeOrZero(Amount operationAmount) {
        return operationAmount.getValue().compareTo(ZERO) <= 0;
    }

    public abstract Amount execute(Statement statement);
    protected abstract void setOperationType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(operationAmount, operation.operationAmount) &&
                operationType == operation.operationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationAmount, operationType);
    }
}
