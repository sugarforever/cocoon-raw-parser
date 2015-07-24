package com.wiysoft.cocoon.rawparser.common;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by weiliyang on 6/30/15.
 */
public final class Utilities {

    public static Date parseDate(SimpleDateFormat dateFormat, String str) {
        Date date = null;
        try {
            if (dateFormat != null && !StringUtils.isEmpty(str)) {
                date = dateFormat.parse(str);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static Double parseDouble(String str, Double defaultValueWithException) {
        Double d = null;
        if (StringUtils.isNotEmpty(str)) {
            try {
                d = Double.parseDouble(str);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                d = defaultValueWithException;
            }
        }

        return d;
    }

    public static Float parseFloat(String str, Float defaultValueWithException) {
        Float f = null;
        if (StringUtils.isNotEmpty(str)) {
            try {
                f = Float.parseFloat(str);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                f = defaultValueWithException;
            }
        }

        return f;
    }

    public static Long parseLong(String str, Long defaultValueWithException) {
        Long l = null;
        if (StringUtils.isNotEmpty(str)) {
            try {
                l = Long.parseLong(str);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                l = defaultValueWithException;
            }
        }

        return l;
    }
}
