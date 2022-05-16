package com.flightbooking.model.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDay {
	
	//converting date into week day
	public  String dateDay(String inputDate) throws ParseException {
	 	  SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
	  Date dt1 = format1.parse(inputDate);
	  DateFormat format2 = new SimpleDateFormat("EEEE"); 
	  String finalDay = format2.format(dt1);
	  return finalDay;
	}
}
