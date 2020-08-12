package com.company.doc_lift.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class dateController {
    public String dateToday(){
        String dateFormat = "dd.MM.yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Calendar cal1 = Calendar.getInstance();
        cal1.add(5, -1);
        return sdf.format(cal1.getTime());
    }
}
