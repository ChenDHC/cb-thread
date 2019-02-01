package com.cb.blockqueue;

import java.util.LinkedList;
import java.util.List;

/**
 * 阻塞队列的实现思想
 */
public class BlockingQueue {
    private List queue = new LinkedList();
    /**
     * 队列默认大小
     */
    private int limit = 10;
    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    /**
     * 生产者
     * @param item
     * @throws InterruptedException
     */
    public synchronized void inQueue(Object item)
            throws InterruptedException {
        // 队列已满，阻塞，释放锁
        while (this.queue.size() == this.limit) {
            wait();
        }
        // 队列为空，通知其他线程，并不释放锁
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }

    /**
     * 消费者
     * @return
     * @throws InterruptedException
     */
    public synchronized Object outQueue()
            throws InterruptedException {
        // 队列为空，阻塞
        while (this.queue.size() == 0) {
            wait();
        }
        // 队列已满，通知其他线程，并没有释放锁
//        if (this.queue.size() == 0) {
//            notifyAll();
//        }
        // 消费，则通知生产线程，可以准备生产了，执行完该方法块，释放锁
        Object o = this.queue.remove(0);
        notifyAll();
        return o;
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue(5);
        Thread creater = new Thread(() -> {
            int i = 0;
            while (true){
                try {
                    Thread.sleep(500);
                    blockingQueue.inQueue(++i);
                    System.out.println("生产了产品："+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true){
                try {
//                    Thread.sleep(20);
                    int consumerItem = (int)blockingQueue.outQueue();
                    System.out.println("消费了产品："+consumerItem);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        creater.start();
        consumer.start();
    }
}
