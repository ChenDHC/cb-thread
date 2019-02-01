package com.cb.volatil;

/**
 * @author ChenOT
 * @date 2019-01-31
 * @see
 * @since
 */
public class VolatileTest {
    public static void main(String[] args) throws InterruptedException {
        while(true){
            Count count = new Count();
            Thread threadA = new Thread(new MyThreadA(count));
            Thread threadB = new Thread(new MyThreadB(count));
            threadA.start();
            threadB.start();
            threadA.join();
            threadB.join();
            threadA.interrupt();
            threadB.interrupt();

//            Thread.sleep(100);
            if(count.getCount()!=3){
                System.out.println("count最终结果："+count.getCount());
                break;
            }
        }


    }
}
