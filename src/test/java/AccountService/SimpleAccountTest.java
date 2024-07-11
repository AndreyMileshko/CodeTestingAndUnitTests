package AccountService;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleAccountTest {

    private Account account;

    @BeforeEach
    void preparatoryProcedures() {
        account = new SimpleAccount();
    }

    @Test
    void initialBalanceTest() {
        assertEquals(0, account.balance);
        MatcherAssert.assertThat(account.balance, Matchers.is(0L));
    }

    @Test
    void balanceChangeWhenRefillingBy1000() {
        account.add(1000);

        assertEquals(1000, account.balance);
        MatcherAssert.assertThat(account.balance, Matchers.is(1000L));
    }

    @Test
    void willReturnTrueOnTopUp() {
        assertTrue(account.add(300));
        MatcherAssert.assertThat(account.add(300), Matchers.is(true));
    }

    @Test
    void willReturnFalseWhenRechargingToANegativeBalance() {
        assertFalse(account.add(-1));
        MatcherAssert.assertThat(account.add(-1), Matchers.is(false));
    }

    @Test
    void willReturnFalseWhenYouPayOverBalance() {
        assertFalse(account.pay(10000));
        MatcherAssert.assertThat(account.pay(10000), Matchers.is(false));
    }

    @Test
    void willReturnTrueIfYouPayWithinTheBalanceLimit() {
        account.add(5000);

        assertTrue(account.pay(1000));
        MatcherAssert.assertThat(account.pay(1000), Matchers.is(true));
    }

    @Test
    void willReturnTheCorrectAmountWhenSpentWithinTheBalanceLimit() {
        account.add(8000);
        account.pay(2000);

        assertEquals(6000, account.balance);
        MatcherAssert.assertThat(account.balance, Matchers.is(6000L));
    }

    @Test
    void theBalanceWillNotChangeWhenSpendingOverTheBalance() {
        account.add(800);
        account.pay(2000);

        assertEquals(800, account.balance);
        MatcherAssert.assertThat(account.balance, Matchers.is(800L));
    }
}
