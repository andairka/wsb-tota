package com.andairka.wsb.tota.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Util class helping with data object manipulation.
 * @author Adrianna Pater (andairka@wp.pl)
 */
public class Utils {

    /**
     * Parse date in String into Date object.
     * @param date Date in String.
     * @return Date object.
     */
    public static Date parseInputDate(String date) {
        Date responseDate = null;
        try {
            responseDate = new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return responseDate;
    }

    /**
     * Returns current date.
     * @return Date with current date.
     */
    public static String getCurrentDate() {
        return new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    }

    /**
     * Parse date in Date intro String with proper format.
     * @param date Date object.
     * @return String date with proper format.
     */
    public static String parseDate(Date date) {
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }
}
