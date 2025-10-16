import java.util.*;

public class Main {

    // 1
    static void printNumbers() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
            if (i % 10 == 0) System.out.println();
        }
    }

    // 2
    static void sumToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        System.out.println(sum);
    }

    // 3
    static void productToN(int n) {
        long prod = 1;
        for (int i = 1; i <= n; i++) prod *= i;
        System.out.println(prod);
    }

    // 4
    static void sumEvenToN(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) sum += i;
        System.out.println(sum);
    }

    // 5
    static void sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        System.out.println(sum);
    }

    // 6
    static void reverseNumber(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        System.out.println(rev);
    }

    // 7
    static void factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        System.out.println(fact);
    }

    // 8
    static void firstDivBy7Above1000() {
        int num = 1001;
        while (num % 7 != 0) num++;
        System.out.println(num);
    }

    // 9
    static void printPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            boolean prime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) { prime = false; break; }
            }
            if (prime) System.out.print(i + " ");
        }
        System.out.println();
    }

    // 10
    static void drawTriangles(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.print("   ");

            for (int j = i-1; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j < n; j++) {
                System.out.print("*");
            }
            System.out.print("   ");
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

    }

    // 11
    static void swapValues(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + " " + b);
    }

    // 12
    static void multiplicationTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    // 13
    static void currencyConverter(int dollars, int exchange) {
        System.out.println(dollars * exchange);
    }

    // 14
    static void evenOrOdd(int n) {
        if (n % 2 == 0) System.out.println("Even");
        else System.out.println("Odd");
    }

    // 15
    static void maxOfThree(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        System.out.println(max);
    }

    // 16
    static void calculator(int a, int b, char op) {
        switch (op) {
            case '+': System.out.println(a + b); break;
            case '-': System.out.println(a - b); break;
            case '*': System.out.println(a * b); break;
            case '/': if (b != 0) System.out.println(a / b); else System.out.println("Error"); break;
            default: System.out.println("Invalid");
        }
    }

    // 17
    static void average(int[] arr) {
        double sum = 0;
        for (int x : arr) sum += x;
        System.out.println(sum / arr.length);
    }

    // 18
    static void searchElement(int[] arr, int target) {
        boolean found = false;
        for (int x : arr) {
            if (x == target) { found = true; break; }
        }
        System.out.println(found ? "Found" : "Not Found");
    }

    // 19
    static void guessNumberGame() {
        Random rand = new Random();
        int num = rand.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int guess;
        do {
            guess = sc.nextInt();
            if (guess < num) System.out.println("Too low");
            else if (guess > num) System.out.println("Too high");
        } while (guess != num);
        System.out.println("Correct!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        // printNumbers();
        // sumToN(10);
        // productToN(5);
        // sumEvenToN(10);
        // sumOfDigits(1234);
        // reverseNumber(1234);
        // factorial(5);
        // firstDivBy7Above1000();
        // printPrimes(30);
         drawTriangles(n);
        // swapValues(5, 10);
        // multiplicationTable(7);
        // currencyConverter(10, 12500);
        // evenOrOdd(7);
        // maxOfThree(3, 9, 5);
        // calculator(10, 5, '+');
        // average(new int[]{2,4,6,8});
        // searchElement(new int[]{1,2,3,4,5}, 3);
        // guessNumberGame();
    }
}
