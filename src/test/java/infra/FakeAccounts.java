package infra;

import model.Account;
import model.Accounts;
import model.Amount;

import java.util.HashMap;
import java.util.Map;

public class FakeAccounts implements Accounts {

    Map<String, Account> accounts = new HashMap<>();

    public FakeAccounts() {
        accounts.put("123", new Account(Amount.of(10)));
    }

    @Override
    public Account findAccountById(String accountId) {
        return accounts.get(accountId);
    }
}
