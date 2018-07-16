package com.cat.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 刘文博
 * 2018/7/9 15:22
 */
public class String2DateConvert implements Converter<String,Date> {

    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        Date date=null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
