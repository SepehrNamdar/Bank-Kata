package model.history;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class History {
    private final List<Statement> history;

    public History() {
        history = new ArrayList<>();
    }

    public List<Statement> getHistory() {
        return history;
    }

    public void add(Statement statement) {
        history.add(statement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history1 = (History) o;
        return Objects.equals(history, history1.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(history);
    }
}
