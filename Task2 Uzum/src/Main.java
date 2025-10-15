import java.util.*;

// 1. Person
class Person {
    String name;
    int age;

    void introduce() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
}

// 2. Rectangle
class Rectangle {
    double length;
    double width;

    double calculateSquare() {
        return length * width;
    }

    double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// 3. Car
class Car {
    String country;
    String model;
    int yearOfManufacture;

    void printCarInfo() {
        System.out.println("Car: " + model + " (" + yearOfManufacture + "), made in " + country);
    }
}

// 4. BankAccount
class BankAccount {
    String fio;
    int accountNumber;
    double balance;

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Not enough funds.");
        }
    }

    double getBalance() {
        return balance;
    }
}

// 5. Book
class Book {
    String isbn;
    String name;
    String author;
    int year;
    boolean status;

    void getBookInfo() {
        System.out.println(name + " by " + author + " (" + year + ")");
    }

    boolean getBooks() {
        return status;
    }

    void addNewBook(String isbn, String name, String author, int year) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = true;
    }

    void reserveBook() {
        if (status) {
            status = false;
            System.out.println("Book reserved.");
        } else {
            System.out.println("Book not available.");
        }
    }
}

// =================== Next Part ===================

// 6. OnlineStore
class OnlineStore {
    int code;
    String name;
    double price;
    int count;

    void addProduct(int code, String name, double price, int count) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    void buyProduct(int qty) {
        if (count >= qty) {
            count -= qty;
            System.out.println(qty + " product(s) bought.");
        } else {
            System.out.println("Not enough products.");
        }
    }

    void getProductInfo() {
        System.out.println("Code: " + code + ", Name: " + name + ", Price: " + price + ", Stock: " + count);
    }

    int getProducts() {
        return count;
    }
}

// 7. BankSystem
class BankSystem {
    ArrayList<BankAccount> accounts = new ArrayList<>();

    void getAccountInfo(int accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.accountNumber == accountNumber) {
                System.out.println("Account: " + acc.fio + ", Balance: " + acc.balance);
            }
        }
    }

    void addAccount(BankAccount acc) {
        accounts.add(acc);
    }

    void deleteAccount(int accountNumber) {
        accounts.removeIf(acc -> acc.accountNumber == accountNumber);
    }

    void replenishAccount(int accountNumber, double amount) {
        for (BankAccount acc : accounts) {
            if (acc.accountNumber == accountNumber) {
                acc.deposit(amount);
            }
        }
    }

    void transferMoneyBetweenAccounts(int fromAcc, int toAcc, double amount) {
        BankAccount sender = null, receiver = null;
        for (BankAccount acc : accounts) {
            if (acc.accountNumber == fromAcc) sender = acc;
            if (acc.accountNumber == toAcc) receiver = acc;
        }
        if (sender != null && receiver != null && sender.balance >= amount) {
            sender.withdraw(amount);
            receiver.deposit(amount);
        }
    }
}

// 8. StreetFighter Game
class Fighter {
    String code;
    String name;
    int health;
    int attack;

    Fighter(String code, String name, int health, int attack) {
        this.code = code;
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    void fight(Fighter opponent) {
        Random rand = new Random();
        Fighter first = rand.nextBoolean() ? this : opponent;
        Fighter second = (first == this) ? opponent : this;

        System.out.println(first.name + " attacks first!");
        while (this.health > 0 && opponent.health > 0) {
            second.health -= first.attack;
            if (second.health <= 0) {
                System.out.println(first.name + " wins!");
                break;
            }
            // swap turns
            Fighter temp = first;
            first = second;
            second = temp;
        }
    }

    void getFighterInfo() {
        System.out.println(name + " [Health: " + health + ", Attack: " + attack + "]");
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Bobur";
        p.age = 25;
        p.introduce();

        Rectangle r = new Rectangle();
        r.length = 5;
        r.width = 3;
        System.out.println("Area: " + r.calculateSquare());
        System.out.println("Perimeter: " + r.calculatePerimeter());

        Car car = new Car();
        car.country = "Germany";
        car.model = "BMW";
        car.yearOfManufacture = 2020;
        car.printCarInfo();

        Fighter f1 = new Fighter("F1", "Asad", 100, 20);
        Fighter f2 = new Fighter("F2", "Bobur", 100, 15);
        f1.getFighterInfo();
        f2.getFighterInfo();
        f1.fight(f2);
    }
}
