package AccountService;

public abstract class Account {

    protected long balance = 0;
    public abstract boolean add(long amount);
    public abstract boolean pay(long amount);
    public boolean transfer(Account account, long amount) {
        if (this.pay(amount)) {
            if (account.add(amount)) {
                return true;
            } else {
                this.add(amount);
                return false;
            }
        } else {
            return false;
        }
    }

    public long getBalance() {
        return balance;
    }

}