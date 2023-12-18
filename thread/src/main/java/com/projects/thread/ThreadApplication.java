package com.projects.thread;
import java.util.concurrent.TimeUnit;

import net.sf.jsqlparser.statement.select.KSQLJoinWindow;
import net.sf.jsqlparser.statement.select.KSQLWindow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@SpringBootApplication
@EnableAsync
public class ThreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadApplication.class, args);
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        // Log the thread count every 10 seconds
        executor.scheduleAtFixedRate(ThreadMonitoring::logThreadCount, 0, 5, TimeUnit.SECONDS);
    }

}
