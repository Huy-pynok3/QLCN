
package com.qlcnnh.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author T14
 */
public class XDate {

    static SimpleDateFormat sdf = new SimpleDateFormat();

    public static Date toDate(String date, String pattern) {
        try {
            sdf.applyPattern(pattern);
            return sdf.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(Date date, String pattern) {
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }

    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }
}