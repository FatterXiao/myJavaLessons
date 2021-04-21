package com.atguigu.day17;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTestJDK8 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = sdf.parse("1922-12-12");

    }
}
