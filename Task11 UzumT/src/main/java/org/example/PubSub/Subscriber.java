package org.example.PubSub;

import java.util.concurrent.BlockingQueue;

public class Subscriber implements Runnable {
    private final BlockingQueue<String> queue;
    private volatile boolean isRunning = true;

    public Subscriber(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (isRunning||!queue.isEmpty()) {

            try {
                String message = queue.take();
                System.out.println("Subscriber:" + message);
                if(message.equalsIgnoreCase("exit")) {
                    break;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
                break;
            }

        }
    }
}
