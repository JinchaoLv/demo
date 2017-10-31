package com.lvjc.test;

import java.math.BigDecimal;

/**
 * Created by lvjc on 2017/7/14.
 */
public class BigDecimalTest {

    public static BigDecimal num = new BigDecimal("22.01");

    public static void main(String[] args) {
        System.out.println(num.add(num));
    }
}
