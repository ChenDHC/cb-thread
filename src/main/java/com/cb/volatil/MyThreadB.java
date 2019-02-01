package com.cb.volatil;

/**
 * @author ChenOT
 * @date 2019-01-31
 * @see
 * @since
 */
public class MyThreadB implements Runnable {
    private Count count;
    public MyThreadB(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        if(count.getCount() == 0){
            count.add(2);
        }else{
            count.add(1);
        }
//        System.out.println("MyThreadB：count="+count.getCount());
    }
}
