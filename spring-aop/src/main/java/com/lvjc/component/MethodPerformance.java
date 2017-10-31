package com.lvjc.component;

/**
 * Created by lvjc on 2017/5/27.
 */
public class MethodPerformance {

    private long begin;
    private long end;
    private String serviceMethodName;

    public void setServiceMethodName(String serviceMethodName) {
        this.serviceMethodName = serviceMethodName;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance() {
        end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(serviceMethodName + "耗时" + elapse + "毫秒。");
    }
}
