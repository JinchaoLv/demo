package com.lvjc.bean;

import com.lvjc.annotation.NeedMonitor;
import com.lvjc.pojo.Waiter;

/**
 * Created by lvjc on 2017/5/31.
 */
public class NaiveWaiter implements Waiter {

    @NeedMonitor
    public void greetTo(String clientName){
        System.out.println("NaiveWaiter:greet to " + clientName + "...");
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serveTo(String clientName){
        System.out.println("NaiveWaiter:serve to " + clientName + "...");
    }
}
