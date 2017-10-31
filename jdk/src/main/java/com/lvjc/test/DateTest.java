package com.lvjc.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lvjc on 2017/7/12.
 */
public class DateTest {

    public static Date date = new Date();

    public static String dateString = "2017-13";//相当于2018-01

    public static SimpleDateFormat format_month = new SimpleDateFormat("yyyy-MM");
    public static SimpleDateFormat format_day = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) throws ParseException {

        System.out.println(format_month.parse(dateString));
        System.out.println(format_month.format(new Date()));
    }
}
