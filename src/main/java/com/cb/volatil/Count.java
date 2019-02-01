package com.cb.volatil;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ChenOT
 * @date 2019-01-31
 * @see
 * @since
 */
@Getter
public class Count {
//    private volatile int count = 0;
    private int count = 0;
    public synchronized void add(int value){
        count+=value;
    }
}
