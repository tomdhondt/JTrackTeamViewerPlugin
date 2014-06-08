package be.jtrackteamviewerplugin.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;


public class DateUtilTest {
	@Test
	public void mapStringToDate(){
		try{
			Date date = MappingUtil.mapStringToDate("18-01-1984 10:15:14",null);
			DateTime dateTime = new DateTime(date.getTime());
			DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss");
			/* check the converted date */
			assertNull(MappingUtil.mapStringToDate(null ,null));
			assertEquals("18-01-1984 10:15:14", dateTime.toString(fmt));
		}catch(UnsupportedOperationException uOe){
		}catch(NullPointerException nPe){
		}catch(IllegalArgumentException iAe){
		}
	}
	@Test
	public void calcDuration(){
		Date start01 = MappingUtil.mapStringToDate("18-01-1984 10:15:14.000",null);
		Date end01 = MappingUtil.mapStringToDate("18-01-1984 11:15:14.000",null);
		assertEquals(0,DateUtil.getStandardDays(DateUtil.calcDuration(start01, end01)));
		assertEquals(1,DateUtil.getStandardHours(DateUtil.calcDuration(start01, end01)));
		assertEquals(60,DateUtil.getStandardMinutes(DateUtil.calcDuration(start01, end01)));
		assertEquals(3600,DateUtil.getStandardSeconds(DateUtil.calcDuration(start01, end01)));
		Date start02 = MappingUtil.mapStringToDate("18-01-1984 10:15:14.000",null);
		Date end02 = MappingUtil.mapStringToDate("20-01-1984 10:15:14.000",null);
		assertEquals(2,DateUtil.getStandardDays(DateUtil.calcDuration(start02, end02)));
		assertEquals(48,DateUtil.getStandardHours(DateUtil.calcDuration(start02, end02)));
		assertEquals(2880,DateUtil.getStandardMinutes(DateUtil.calcDuration(start02, end02)));
		assertEquals(172800,DateUtil.getStandardSeconds(DateUtil.calcDuration(start02, end02)));
		Date start03 = MappingUtil.mapStringToDate("20-01-1984 10:15:14.000",null);
		Date end03 = MappingUtil.mapStringToDate("18-01-1984 10:16:14.000",null);
		assertEquals(1,DateUtil.getStandardDays(DateUtil.calcDuration(start03, end03)));
		assertEquals(47,DateUtil.getStandardHours(DateUtil.calcDuration(start03, end03)));
		assertEquals(2879,DateUtil.getStandardMinutes(DateUtil.calcDuration(start03, end03)));
		assertEquals(172740,DateUtil.getStandardSeconds(DateUtil.calcDuration(start03, end03)));
	}
	@Test
	public void dateCalcMilliseconds(){
		Date date01 = MappingUtil.mapStringToDate("18-01-1984 10:15:14.000",null);
		long milliSeconds01 = 86400000;
		long milliSeconds02 = -86400000;
		Date dateResult01 = DateUtil.dateCalcMilliseconds(date01, milliSeconds01);
		Date dateResult02 = DateUtil.dateCalcMilliseconds(date01, milliSeconds02);
		assertEquals(dateResult01.toString(), "Thu Jan 19 10:15:14 CET 1984");
		assertEquals(dateResult02.toString(), "Tue Jan 17 10:15:14 CET 1984");
	}
}
