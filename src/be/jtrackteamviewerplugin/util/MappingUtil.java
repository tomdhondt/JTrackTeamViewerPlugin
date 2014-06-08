package be.jtrackteamviewerplugin.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public abstract class MappingUtil {
	/* instance members */
	private static final Logger logger = Logger.getLogger(MappingUtil.class);
	/**
	 * Method will delete the white spaces out the string
	 * @param string as String
	 * @return String as result
	 */
	public static String deleteSpaces(String string){
		/* check if there are white spaces */
		char[] list = string.toCharArray();
		StringBuilder out = new StringBuilder();
		char ch = ' ';
		if(string.contains(" ")){			
			for(char c : list){
				if(!(ch == c)){
					out.append(c);
				}
			}
		}
		return out.toString();
	}
	/**
	 * Method will map a int to a String
	 * @param object as int
	 * @return result as String
	 */
	public static String mapIntToString(int object){
		if(-1 == object){
			return null;
		}
		return Integer.toString(object);
	}
	/**
	 * Method will parse a String to a int
	 * @param object as String
	 * @return object as int
	 * @throws NumberFormatException
	 */
	public static int mapStringToInt(String object) throws NumberFormatException{
		int value = 0;
		if(null != object){
			try{
				value = Integer.parseInt(object);
			}catch(NumberFormatException nFe){
				logger.error("Could not parse the object to a int");
				throw new NumberFormatException();
			}
		}
		return value;
	}
	/**
	 * Method will parse a String to a int
	 * @param object as String
	 * @return object as int
	 * @throws NumberFormatException
	 */
	public static BigDecimal mapStringToBigDecimal(String object) {
		BigDecimal value = null;
		if(null != object){
			try{
				value = new BigDecimal(object);
			}catch(NumberFormatException nFe){
				logger.error("Could not parse the object to a BigDecimal");
				throw new NumberFormatException();
			}
		}
		return value;
	}
	/**
	 * Method will parse a BigDecimal to a String
	 * @param object as BigDecimal
	 * @return object as String
	 * @throws Exception
	 */
	public static String mapBigDecimalToString(BigDecimal object) throws Exception{
		String value = null;
		if(null != object){
			try{
				value = object.toString();
			}catch(Exception nFe){
				logger.error("Could not parse the object to a String");
				throw new Exception();
			}
		}
		return value;
	}
	/**
	 * Method will parse a Date to a String
	 * @param date as java.util.Date
	 * @param format as String (default format dd-MM-yyyy hh:mm:ss.SSS)
	 */
	public static String mapDateToString(Date dateModified, String format){
		DateTimeFormatter dtf = null;		
		String dateAsString = null;
		if(null != format){
			dtf = DateTimeFormat.forPattern(format);
		}else{
			dtf = DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss.SSS");
		}
		try{
			if(null != dateModified){
				DateTime dateTime = new DateTime(dateModified.getTime());
				dateAsString = dateTime.toString(dtf);
			}
		}catch(NullPointerException nPe){
			throw new NullPointerException(nPe.getMessage());
		}catch(UnsupportedOperationException uOe){
			throw new UnsupportedOperationException(uOe.getMessage());
		}catch(IllegalArgumentException iAe){
			throw new IllegalArgumentException(iAe.getMessage());
		}
		return dateAsString;
	}
	/**
	 * Method will map a String to a java.util.Date
	 * @param dateModified as java.util.Date
	 * @param format as String
	 * @return date as java.util.Date
	 * @throws ParseException 
	 */
	public static Date mapStringToDate(String dateModified, String format) throws UnsupportedOperationException, NullPointerException, IllegalArgumentException{
		DateTimeFormatter dtf = null;		
		Date date = null;
		if(null != format){
			dtf = DateTimeFormat.forPattern(format);
		}else{
			dtf = DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss.SSS");
		}
		try{
			DateTime jDate = dtf.parseDateTime(dateModified);
			date = new Date(jDate.getMillis());
		}catch(NullPointerException nPe){
			throw new NullPointerException(nPe.getMessage());
		}catch(UnsupportedOperationException uOe){
			throw new UnsupportedOperationException(uOe.getMessage());
		}catch(IllegalArgumentException iAe){
			throw new IllegalArgumentException(iAe.getMessage());
		}
		return date;
	}
}
