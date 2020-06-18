package model.operations;

import model.account.Amount;
import model.history.Statement;

public class Deposit extends Operation {

    public Deposit(Amount depositAmount) {
        super(depositAmount);
    }

    @Override
    public Amount execute(Statement statement) {
        return statement.getBalance().add(operationAmount);
    }

    @Override
    public void setOperationType() {
        super.operationType = OperationType.DEPOSIT;
    }
}
