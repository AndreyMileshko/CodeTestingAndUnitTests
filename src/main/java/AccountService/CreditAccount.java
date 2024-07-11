package AccountService;

public class CreditAccount extends Account{

    private final long CREDIT_LIMIT;

    public CreditAccount(long creditLimit) {
        this.CREDIT_LIMIT = - Math.abs(creditLimit);
    }

    @Override
    public boolean add(long amount) {
        if ((balance + amount) <= 0 && amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean pay(long amount) {
        if ((balance - amount) >= CREDIT_LIMIT && amount > 0) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}