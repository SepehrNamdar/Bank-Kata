package use_case;

import infra.FakeAccounts;
import model.Account;
import model.Amount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Deposit_In_Bank_Account_Should {

    public static final String ACCOUNT_ID = "123";

    private FakeAccounts accounts;

    @BeforeEach
    public void init() {
        accounts = new FakeAccounts();
    }

    @Test
    void increase_bank_account_balance() {
        var deposit_in_bank_account = new Deposit_In_Bank_Account(accounts);

        deposit_in_bank_account.execute(ACCOUNT_ID, Amount.of(11));

        Account account = accounts.findAccountById(ACCOUNT_ID);
        Account expectedAccount = new Account(Amount.of(21));
        assertThat(account).isEqualTo(expectedAccount);
    }
}
