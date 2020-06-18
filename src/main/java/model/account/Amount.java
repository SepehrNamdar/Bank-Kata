package model.account;

import java.math.BigDecimal;
import java.util.Objects;

public class Amount {
    private final BigDecimal value;

    public Amount(double amount) {
        this.value = BigDecimal.valueOf(amount);
    }

    private Amount(BigDecimal amount) {
        value = amount;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Amount subtract(Amount operationAmount) {
        return new Amount(this.value.subtract(operationAmount.getValue()));
    }

    public Amount add(Amount operationAmount) {
        return new Amount(this.value.add(operationAmount.getValue()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Objects.equals(value, amount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
