package com.lvjc.component;

/**
 * Created by lvjc on 2017/5/27.
 */
public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<>();

    public static void begin(String methodName) {
        System.out.println("begin monitor...");
        MethodPerformance methodPerformance = new MethodPerformance();
        methodPerformance.setServiceMethodName(methodName);
        performanceRecord.set(methodPerformance);
    }

    public static void end() {
        System.out.println("end monitor...");
        MethodPerformance mp = performanceRecord.get();
        mp.printPerformance();
    }
}
