package com.projects.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class AsyncController {

    private final AsyncService asyncService;

    @Autowired
    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/startAsyncTask")
    public ResponseEntity<String> startAsyncTask() {
        CompletableFuture<String> futureResult = asyncService.performLongRunningTask();

        // Non-blocking - return a response immediately
        return ResponseEntity.ok("Async task started. Check logs for progress.");
    }

    @GetMapping("/startTaskWithoutAsync")
    public ResponseEntity<String> startTask() throws InterruptedException {
        String result = asyncService.performTaskWithoutAsync();
        return ResponseEntity.ok("Non Async task started");
    }
}
