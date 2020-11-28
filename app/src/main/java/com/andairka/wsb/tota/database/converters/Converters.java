package com.andairka.wsb.tota.database.converters;

import androidx.room.TypeConverter;
import java.util.Date;

/**
 * Converter which is used by Room when fetching data from database.
 * @author Adrianna Pater (andairka@wp.pl)
 */
public class Converters {

    /**
     * Convert from Long to Date.
     * @param value Long time in milliseconds.
     * @return Date.
     */
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    /**
     * Convert from Date to Long
     * @param date Date object.
     * @return Long time in miliseconds
     */
    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}