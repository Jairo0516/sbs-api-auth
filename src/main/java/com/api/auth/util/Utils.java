package com.api.auth.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static io.vavr.API.Option;

public final class Utils {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_FORMAT);
    public static final DateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
    public static final java.time.format.DateTimeFormatter dataBaseDateFormatter = java.time.format.DateTimeFormatter.ofPattern(DATE_FORMAT);

    private static final Integer DEFAULT_INTEGER_VALUE = 0;
    private static final Long DEFAULT_LONG_VALUE = 0L;
    private static final Double DEFAULT_DOUBLE_VALUE = 0.0;

    private static final String DATE_FORMAT_ERROR = "Error formatting date";

    public static String convertToString(Date date) {
        return Option(date).map(d -> new DateTime(d)).map(dateTime -> dateTime.toString(formatter)).getOrElse(StringUtils.EMPTY);
    }

    public static Integer defaultValueInteger(Integer value) {
        return Option(value).getOrElse(DEFAULT_INTEGER_VALUE);
    }

    public static Long defaultValueLong(Long value) {
        return Option(value).getOrElse(DEFAULT_LONG_VALUE);
    }

    public static Double defaultValueDouble(Double value) {
        return Option(value).getOrElse(DEFAULT_DOUBLE_VALUE);
    }

    public static Date calculateDate(Date date, Integer value, String measure ) {
        measure = measure.toLowerCase();
        DateTime dateTime = new DateTime(date);
        if (Constants.YEARS_WITHOUT.equals(measure) || Constants.YEARS.equals(measure)) {
            return dateTime.plusYears(value).toDate();
        } else if (Constants.MONTHS.equals(measure)) {
            return dateTime.plusMonths(value).toDate();
        } else if (Constants.DAYS.equals(measure) || Constants.DAYS_ACCENT_MARK.equals(measure)) {
            return dateTime.plusDays(value).toDate();
        } else {
            return date;
        }
    }

    public static String getStackTrace(Throwable ex) {
        StringBuffer sb = new StringBuffer(5000);
        StackTraceElement[] st = ex.getStackTrace();
        sb.append(ex.getClass().getName() + ": " + ex.getMessage() + "\n");
        for (int i = 0; i < st.length; i++) {
            sb.append("\t at " + st[i].toString() + "\n");
        }
        return sb.toString();
    }

    public static Date stringToDate( String date ) {
        try {
            return ( null == date ? null : dateFormatter.parse( date ) );
        } catch (ParseException parEx) {
            throw new IllegalArgumentException(DATE_FORMAT_ERROR, parEx);
        }
    }

    public static Date stringToDateOrNull(String date ) {
        return Option(date).map(d -> {
            try {
                return formatter.parseDateTime(date).toDate();
            } catch (Exception e) {
                return null;
            }
        }).getOrNull();
    }


    public static LocalDate stringToLocalDateOrNull(String date) {
        return Option(date).map(d -> {
            try {
                return LocalDate.parse(date, dataBaseDateFormatter);
            } catch (Exception e) {
                return null;
            }
        }).getOrNull();
    }
}