package com.cb.threadlocal;

import java.util.concurrent.locks.Lock;

/**
 * @author ChenOT
 * @date 2019-01-31
 * @see
 * @since
 */
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }
}
