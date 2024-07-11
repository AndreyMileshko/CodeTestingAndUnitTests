import AccountService.*;

public class Main {
    public static void main(String[] args) {
        new Demo().demo();
    }
}
class Demo {
    public void demo() {
        System.out.println("Simple Account: ");
        Account account = new SimpleAccount();
        account.add(10_000);
        System.out.println("Баланс первого аккаунта: " + account.getBalance());
        account.pay(5_000);
        System.out.println("Баланс первого аккаунта после траты: " + account.getBalance());
        account.pay(10_000);
        System.out.println("Баланс первого аккаунта после попытки траты сверх баланса: " + account.getBalance());

        Account account1 = new SimpleAccount();
        account.transfer(account1, 3000);
        System.out.println("Баланс первого аккаунта после перевода на второй: " + account.getBalance());
        System.out.println("Баланс второго аккаунта после пополнения с первого: " + account1.getBalance());

        System.out.println("\nCredit Account: ");
        CreditAccount creditAccount = new CreditAccount(100_000);
        System.out.println("Баланс первого кредитного аккаунта: " + creditAccount.getBalance());
        creditAccount.pay(80_000);
        System.out.println("Баланс первого кредитного аккаунта после траты: " + creditAccount.getBalance());
        creditAccount.add(10_000);
        System.out.println("Баланс первого кредитного аккаунта после пополнения: " + creditAccount.getBalance());
        creditAccount.add(100_000);
        System.out.println("Проверка пополнения кредитного аккаунта для положительного баланса : " + creditAccount.getBalance());
        creditAccount.pay(100_000);
        System.out.println("Проверка траты сверх кредитного лимита: " + creditAccount.getBalance());

        creditAccount.transfer(account, 10_000);
        System.out.println("Баланс кредитного аккаунта после перевода на простой аккаунт: " + creditAccount.getBalance());
        System.out.println("Баланс первого простого аккаунта после пополнения с кредитного: " + account.getBalance());

        System.out.println();
        account.add(80_000);
        System.out.println("Баланс кредитного аккаунта: " + creditAccount.getBalance());
        System.out.println("Баланс простого аккаунта: " + account.getBalance());
        System.out.println("Ситуация когда pay вернул true, а add - false: " + account.transfer(creditAccount, 90_000));
        System.out.println("Баланс кредитного аккаунта: " + creditAccount.getBalance());
        System.out.println("Баланс простого аккаунта: " + account.getBalance());
    }
}