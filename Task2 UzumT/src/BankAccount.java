public class BankAccount {
    String fio;
    String accountNumber;
    double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Not enough funds!");
        }
    }

    public double getBalance() {
        return balance;
    }
}
