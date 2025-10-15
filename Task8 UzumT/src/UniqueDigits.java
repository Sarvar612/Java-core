import java.util.*;

public class UniqueDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите цифры через пробел: ");
        String input = sc.nextLine();

        String[] parts = input.split(" ");
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String p : parts) {
            uniqueNumbers.add(Integer.parseInt(p));
        }

        System.out.println("Уникальные цифры: " + uniqueNumbers);
        sc.close();
    }
}
