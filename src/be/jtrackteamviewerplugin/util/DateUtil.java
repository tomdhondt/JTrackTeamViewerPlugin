package be.jtrackteamviewerplugin.util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Duration;
/**
 * Class that let me do certain date manipulations
 * 
 * @author Tom D'hondt
 * 
 */
public abstract class DateUtil {
	private static final DateFormat utilDateFormatter = new SimpleDateFormat("HH:mm:ss");
	/**
	 * Method will allow me to cast a Date to a String.
	 * @param sDate as a java.util.Date
	 * @return date as a String
	 */
	public static String sqlDateToutilString(java.util.Date sDate)
	{
		return (String) utilDateFormatter.format(sDate);
	}
	/**
	 * public StringDateToLong will cast a Date to a long.
	 * @param date as a String date "yyyy-MM-dd HH:mm:ss"
	 * @return long as the result of the cast
	 */
	public static long stringDateToLong(String date){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");											// create a dateFormatter
		long result = 0;																			// create member to return the result
		try {							
			Date date1 = sdf.parse(date);															// create a date and parse the string
			result = date1.getTime();																// set the result 
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return result;																				// return the result
	}
	/**
	 * public StringDateToLong will cast a Date to a long.                                                                                                                                                 n    
	 * @param date as a String
	 * @param sdf as SimpleDateFormat to convert the dateTime
	 * @return long as the result of the cast
	 */
	public static long stringDateToLong(String date, SimpleDateFormat sdf){
		long result = 0;																			// create member to return the result
		try {							
			Date date1 = sdf.parse(date);															// create a date and parse the string
			result = date1.getTime();																// set the result 
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return result;																				// return the result
	}
	/**
	 * public StringDateToLong will cast a Date to a long.
	 * @param date as a String
	 * @param sdf as SimpleDateFormat to convert the dateTime
	 * @return long as the result of the cast
	 * @throws ParseException when the date could not be parsed
	 */
	public static long stringDateToLong(SimpleDateFormat sdf, String date){
		long result = 0;																			// create member to return the result
		try {							
			Date date1 = sdf.parse(date);															// create a date and parse the string
			result = date1.getTime();																// set the result
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return result;																				// return the result
	}
	/**
	 * public StringTimeToLong will cast a Date to a long.
	 * @param time as a String time "HH:mm:ss"
	 * @return long as the result of the cast
	 */
	public static long stringTimeToLong(String time){
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");											// create a dateFormatter
		long result = 0;																			// create member to return the result
		try {							
			Date date1 = sdf.parse(time);															// create a date and parse the string
			result = date1.getTime();																// set the result 
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return result;																				// return the result
	}
	/**
	 * Method calcSeconds will allow me to calculate the amount of seconds there are in a date.
	 * @param date1 as a string
	 * @return int as the amount of milliseconds between the 2 dates
	 */
	public static int calcSeconds(long date1){
			DateTime sec = new DateTime(date1);
			return sec.getSecondOfDay();
	}
	/**
	 * Method calcDifSeconds will allow you to calculate the amount of seconds between 2 date.
	 * @param date1 as long
	 * @param date2 as long
	 * @return int as the difference between 2 dates
	 */
	public static int calcDifSeconds(long date1, long date2){
		int dateSec1 = DateUtil.calcSeconds(date1);
		int dateSec2 = DateUtil.calcSeconds(date2);
		int result = -1;
		if(dateSec1 > dateSec2){
			result = dateSec1 - dateSec2;
		}else{
			result = dateSec2 - dateSec1;
		}
		return result;
	}
	/**
	 * Method will allow you to return the year as a int.
	 * @param date1 as a long
	 * @return year as int
	 */
	public static int getYear(long date1){
		DateTime year = new DateTime(date1);
		return year.getYear();
	}
	/**
	 * Method will allow you to return the month as a int.
	 * @param date1 as a Long
	 * @return month as a int
	 */
	public static int getMonthInt(long date1){
		DateTime month = new DateTime(date1);
		return month.getMonthOfYear();
	}
	/**
	 * Method will allow you to return the month as a String.
	 * @param date1 as a Long
	 * @return month as a String
	 */
	public static String getMonth(long date1){
		DateTime month = new DateTime(date1);
		month.getMonthOfYear();
		final String MONTH1 = "Januarie";
		final String MONTH2 = "Februarie";
		final String MONTH3 = "Maart";
		final String MONTH4 = "April";
		final String MONTH5 = "Mei";
		final String MONTH6 = "Juni";
		final String MONTH7 = "Juli";
		final String MONTH8 = "Augustus";
		final String MONTH9 = "September";
		final String MONTH10 = "Oktober";
		final String MONTH11 = "November";
		final String MONTH12 = "December";
		
		String resultMonth = "";
		switch (month.getMonthOfYear()){
		case 1:
			resultMonth = MONTH1;
			break;
		case 2:
			resultMonth = MONTH2;
			break;
		case 3:
			resultMonth = MONTH3;
			break;
		case 4:
			resultMonth = MONTH4;
			break;
		case 5:
			resultMonth = MONTH5;
			break;
		case 6: 
			resultMonth = MONTH6;
			break;
		case 7:
			resultMonth = MONTH7;
			break;
		case 8:
			resultMonth = MONTH8;
			break;
		case 9:
			resultMonth = MONTH9;
			break;
		case 10:
			resultMonth = MONTH10;
			break;
		case 11:
			resultMonth = MONTH11;
			break;
		case 12: 
			resultMonth = MONTH12;
			break;
		}
		return resultMonth;
	}
	/**
	 * Method will allow you to return the day as a String.
	 * @param date1 as a Long
	 * @return day as a String
	 */
	public static String getDayOfWeek(long date1){
		DateTime month = new DateTime(date1);
		final String DAY1 = "Monday";
		final String DAY2 = "Tuesday";
		final String DAY3 = "Wednesday";
		final String DAY4 = "Thursday";
		final String DAY5 = "Friday";
		final String DAY6 = "Saterday";
		final String DAY7 = "Sunday";
		String day = "";
		switch(month.getDayOfWeek()){
		case 1:
			day = DAY1;
			break;
		case 2:
			day = DAY2;
			break;
		case 3:
			day = DAY3;
			break;
		case 4:
			day = DAY4;
			break;
		case 5:
			day = DAY5;
			break;
		case 6:
			day = DAY6;
			break;
		case 7:
			day = DAY7;
			break;
		}
		return day;
	}
	/**
	 * Method getCurentDateAsString will allow you to get the current date as a String
	 * @param format as String (default format = dd-mm-yyyy hh:MM:ss.SSS)
	 * @return String as date
	 */
	public static String getCurentDateAsString(String format){
		SimpleDateFormat sdf = null;
		if(null != format){
			sdf = new SimpleDateFormat(format);
		}else{
			sdf = new SimpleDateFormat("dd-mm-yyyy hh:MM:ss.SSS");
		}
		Calendar cd = Calendar.getInstance();							// get instance of calandar				
		String date = sdf.format(cd.getTime());							// format the date
		return date;													// return the String
	}
	/**
	 * Method getCurentDate will allow you to get the current java.util.Date
	 * @return Date as current date
	 */
	public static Date getCurentDate(){
		Calendar cd = Calendar.getInstance();							// get instance of Calendar				
		return cd.getTime();											// return the current java.util.Date
	}
	/**
	 * Method will calculate the number of seconds in the date
	 * @param date as long
	 * @return int as number of seconds of the time
	 */
	public static int getInSeconds(long date){
		DateTime sec = new DateTime(date);
		return sec.getSecondOfDay();
	}
	/**
	 * Method will calculate the duration between to java.util.Date objects
	 * @param start as java.util.Date
	 * @param end as java.util.Date
	 * @return duration as org.joda.time.Duration
	 */
	public static Duration calcDuration(Date start, Date end){
		/* convert the java.util.date to a org.joda.time.DateTime*/
		Duration duration = null;
		if(null != start && null != end){
			try{
				/* convert date to org.joda.time.DateTime*/
				DateTime startDate = new org.joda.time.DateTime(start.getTime());
				DateTime endDate = new org.joda.time.DateTime(end.getTime());
				/* check witch is the biggest DateTime */
				if(startDate.isBefore(endDate.getMillis())){
					duration = new Duration(startDate, endDate);
				}else{
					duration = new Duration(endDate,startDate);
				}
			}catch(Exception eXp){
			}
		}
		return duration;
	}
	/**
	 * Method will return the number of days in the org.joda.time.Duration
	 * @return long as number of days
	 */
	public static long getStandardDays(Duration duration){
		long numberOfDays = 0;
		if(null != duration){
			numberOfDays = duration.getStandardDays();
		}
		return numberOfDays;
	}
	/**
	 * Method will return the number of hours in the org.joda.time.Duration
	 * @return long as number of hours
	 */
	public static long getStandardHours(Duration duration){
		long numberOfDays = 0;
		if(null != duration){
			numberOfDays = duration.getStandardHours();
		}
		return numberOfDays;
	}
	/**
	 * Method will return the number of minutes in the org.joda.time.Duration
	 * @return long as number of minutes
	 */
	public static long getStandardMinutes(Duration duration){
		long numberOfDays = 0;
		if(null != duration){
			numberOfDays = duration.getStandardMinutes();
		}
		return numberOfDays;
	}
	/**
	 * Method will return the number of minutes in the org.joda.time.Duration
	 * @return long as number of minutes
	 */
	public static long getStandardSeconds(Duration duration){
		long numberOfDays = 0;
		if(null != duration){
			numberOfDays = duration.getStandardSeconds();
		}
		return numberOfDays;
	}
	/**
	 * Method will calculate calculate the new Date based on the parameter in the method
	 * @param baseDate as java.util.Date
	 * @param milliseconds as long
	 * @return result as java.util.Date
	 */
	public static Date dateCalcMilliseconds(Date baseDate, long milliseconds){
		/* Date created to return result */
		Date resultDate = baseDate; 
		/* check the baseDate */
		if(null != baseDate){
			/* create duration based on the parameter */
//			Duration calcMilli = new Duration(milliseconds);
			DateTime result = new DateTime(baseDate.getTime());
			/* calculate the new Date */
			DateTime newResult = result.plusMinutes(10);
			/* convert the result to a java.util.Date*/
			resultDate = new Date(newResult.getMillis());
		}
		return resultDate;
	}
}