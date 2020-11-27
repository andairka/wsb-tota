package com.andairka.wsb.tota.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date parseInputDate(String date) {
        Date responseDate = null;
        try {
            responseDate = new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return responseDate;
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    }

    public static String parseDate(Date date) {
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }
}
