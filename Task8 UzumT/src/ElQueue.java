import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ElQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        String command;

        while (true) {
            System.out.println("Введите команду (add, process, exit): ");
            command = sc.nextLine();

            if (command.equalsIgnoreCase("add")) {
                System.out.print("Введите имя пользователя: ");
                String name = sc.nextLine();
                queue.add(counter + ". " + name);
                System.out.println("Пользователь добавлен с номером: " + counter);
                counter++;
            } else if (command.equalsIgnoreCase("process")) {
                if (queue.isEmpty()) {
                    System.out.println("Очередь пуста!");
                } else {
                    System.out.println("Обрабатывается: " + queue.poll());
                }
            } else if (command.equalsIgnoreCase("exit")) {
                break;
            }
        }
        sc.close();
    }
}
