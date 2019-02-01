package com.cb;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ChenOT
 * @date 2019-01-04
 * @see
 * @since
 */
public class Test {
    private final String[] ss = new String[]{"1"};
    public String[] getSs(){
        return ss;
    }
    static class InTest{
        public static void main(String[] args) {
            Test test = new Test();
            String[] ss = test.getSs();
            System.out.println(ss[0]);
            ss[0] = "2";
            System.out.println(test.getSs()[0]);
        }
    }
    private final static AtomicLong atomicLong = new AtomicLong();
    public static void main(String[] args) {
        atomicLong.getAndDecrement();
        Date date1 = new Date();
        System.out.println("1-"+date1.getTime());
        change(date1);
        System.out.println("4-"+date1.getTime());
    }

    public static void change(Date date){
        System.out.println("2-"+date.getTime());
        date.setTime(8L);
        System.out.println("3-"+date.getTime());

    }
}
