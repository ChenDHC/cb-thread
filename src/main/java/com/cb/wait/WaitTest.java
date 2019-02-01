package com.cb.wait;

import java.util.concurrent.BlockingQueue;

/**
 * @author ChenOT
 * @date 2019-02-01
 * @see
 * @since
 */
public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Object lock = new Object();
        synchronized (obj) {
            System.out.println(1);
//            obj.wait();
            System.out.println(2);
            obj.notifyAll();
            System.out.println(3);
        }
    }
}
