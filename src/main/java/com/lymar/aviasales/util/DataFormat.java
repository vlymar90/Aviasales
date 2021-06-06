package com.lymar.aviasales.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataFormat {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");

    public static String getData(String data) {
        try {
            Date convertData = dateFormat.parse(data);
            return convertData.toString();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
