package com.mtt;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread myThread = new MyThread(counter);
        myThread.start();
        MyRunnable myRunnable = new MyRunnable(counter);
        new Thread(myRunnable).start();
    }
}
