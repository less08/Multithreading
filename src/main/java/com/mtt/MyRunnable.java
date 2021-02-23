package com.mtt;

import org.apache.log4j.Logger;

public class MyRunnable implements Runnable {
    private static final Logger logger = Logger.getLogger(MyRunnable.class);
    private static final int MAX_COUNT = 100;
    private Counter counter;

    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("MyRunnable is running...");
        while (counter.getCount() != MAX_COUNT) {
            counter.increase();
            logger.info("Thread: " + counter.getCount());
        }
    }
}
