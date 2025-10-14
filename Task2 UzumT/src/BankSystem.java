import java.util.ArrayList;

public class BankSystem {
    String accountNumber;
    String fio;
    double balance;

    static ArrayList<BankSystem> accounts = new ArrayList<>();

    public void getAccountInfo() {
        System.out.println("Account: " + accountNumber + " | Name: " + fio + " | Balance: " + balance);
    }

    public static void addAccount(BankSystem acc) {
        accounts.add(acc);
    }

    public static void deleteAccount(String accNumber) {
        accounts.removeIf(a -> a.accountNumber.equals(accNumber));
    }

    public void replenishAccount(double amount) {
        balance += amount;
    }

    public static void transferMoneyBetweenAccounts(String from, String to, double amount) {
        BankSystem sender = null, receiver = null;
        for (BankSystem a : accounts) {
            if (a.accountNumber.equals(from)) sender = a;
            if (a.accountNumber.equals(to)) receiver = a;
        }
        if (sender != null && receiver != null && sender.balance >= amount) {
            sender.balance -= amount;
            receiver.balance += amount;
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Transfer failed!");
        }
    }
}
