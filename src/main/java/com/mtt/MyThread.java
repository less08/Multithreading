package com.mtt;

import org.apache.log4j.Logger;

public class MyThread extends Thread {
    private static final Logger logger = Logger.getLogger(MyThread.class);
    private static final int MAX_COUNT = 100;
    private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("MyThread is running...");
        while (counter.getCount() != MAX_COUNT) {
            counter.increase();
            logger.info("Thread: " + counter.getCount());
        }
    }

}
