package org.example.SimplePull;

import java.time.ZonedDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUsage {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int taskNum = i;
            executorService.submit(() -> {
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " executing task number:" + taskNum);
                System.out.println("completed task number:" + taskNum);
            });
        }
        executorService.shutdown();
        try{
            if(!executorService.awaitTermination(5, TimeUnit.SECONDS)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        System.out.println("All tasks completed");
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " ms");
    }
}
