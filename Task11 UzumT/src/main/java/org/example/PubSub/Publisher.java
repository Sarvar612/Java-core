package org.example.PubSub;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Publisher implements Runnable {
    private BlockingQueue <String> queue;
    private Scanner scanner = new Scanner(System.in);

    public Publisher(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Please enter a string:");
        while (true) {
            String string = scanner.nextLine();
            try {
                queue.put(string);
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            if (string.equalsIgnoreCase("exit")) {
                break;
            }

        }
    }
}
