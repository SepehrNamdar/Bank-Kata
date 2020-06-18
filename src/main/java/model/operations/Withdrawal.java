package model.operations;

import model.account.Amount;
import model.history.Statement;

import static model.operations.OperationType.WITHDRAWAL;

public class Withdrawal extends Operation {

    public Withdrawal(Amount withdrawalAmount) {
        super(withdrawalAmount);
    }

    @Override
    public Amount execute(Statement statement) {
        return statement.getBalance().subtract(operationAmount);
    }

    @Override
    public void setOperationType() {
        super.operationType = WITHDRAWAL;
    }
}
