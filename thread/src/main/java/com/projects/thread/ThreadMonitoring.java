package com.projects.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ThreadMonitoring {
    public static void logThreadCount() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        int activeThreadCount = threadMXBean.getThreadCount();

        System.out.println("Current number of active threads: " + activeThreadCount);
    }
}
