package org.example.PubSub;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        Publisher publisher = new Publisher(blockingQueue);
        Subscriber subscriber = new Subscriber(blockingQueue);
        Thread threadP = new Thread(publisher);
        Thread threadS = new Thread(subscriber);
        threadP.start();
        threadS.start();
        try {
            threadP.join();
            threadS.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}