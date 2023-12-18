package com.projects.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Async
    public CompletableFuture<String> performLongRunningTask() {
        long startTime = System.currentTimeMillis(); // Record start time

        try {
            // Simulating a complex task
            int totalOperations = 10;
            for (int i = 0; i < totalOperations; i++) {
                // Simulating a single operation taking 1 second
                Thread.sleep(1000);
                System.out.println("Operation " + (i + 1) + " of " + totalOperations + " completed.");
            }

            long endTime = System.currentTimeMillis(); // Record end time
            long duration = endTime - startTime; // Calculate duration

            System.out.println("Task Completed Successfully in " + duration + " milliseconds");
            return CompletableFuture.completedFuture("Task Completed Successfully in " + duration + " milliseconds");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            long endTime = System.currentTimeMillis(); // Record end time
            long duration = endTime - startTime; // Calculate duration

            System.out.println("Task Interrupted after " + duration + " milliseconds");
            return CompletableFuture.completedFuture("Task Interrupted after " + duration + " milliseconds");
        }
    }
    public String performTaskWithoutAsync() throws InterruptedException {
        long startTime = System.currentTimeMillis(); // Record start time

        int totalOperations = 10;
        for(int i=0; i<totalOperations; i++){
            Thread.sleep(1000);
            System.out.println("Operation " + (i + 1) + " of " + totalOperations + " completed.");
        }
        long endTime = System.currentTimeMillis(); // Record end time
        long duration = endTime - startTime; // Calculate duration

        System.out.println("Task Completed Successfully in " + duration + " milliseconds");
        return "Task Complete Successfully";
    }
}