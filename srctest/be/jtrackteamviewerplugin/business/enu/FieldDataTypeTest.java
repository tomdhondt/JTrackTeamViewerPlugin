package be.jtrackteamviewerplugin.business.enu;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class FieldDataTypeTest {

	@Test
	public void testSearchEnumValue() {
		FieldDataType test = FieldDataType.searchEnumValue("date");
		assertEquals(FieldDataType.date.getName(), test.getName());
	}
	@Test
	public void testRegeXnumber() {
		Pattern pattern = Pattern.compile(FieldDataType.number.getRegex());
		Matcher matcher01 = pattern.matcher("1234");
		Matcher matcher02 = pattern.matcher("test1234");
		Matcher matcher03 = pattern.matcher("1234.00");
		Matcher matcher04 = pattern.matcher(".1234.00");
		assertTrue(matcher01.find());
		assertFalse(matcher02.find());
		assertTrue(matcher03.find());
		assertFalse(matcher04.find());
	}
	@Test
	public void testRegeXdate() {
		Pattern pattern = Pattern.compile(FieldDataType.date.getRegex());
		Matcher matcher01 = pattern.matcher("1234");
		Matcher matcher02 = pattern.matcher("12/12/2012");
		Matcher matcher03 = pattern.matcher("12.12.2012");
		Matcher matcher04 = pattern.matcher("12-12-2012");
		Matcher matcher05 = pattern.matcher("1212/2012");
		Matcher matcher06 = pattern.matcher("12.122012");
		Matcher matcher07 = pattern.matcher("12122012");
		Matcher matcher08 = pattern.matcher("12/12/2012t");
		assertFalse(matcher01.find());
		assertTrue(matcher02.find());
		assertTrue(matcher03.find());
		assertTrue(matcher04.find());
		assertFalse(matcher05.find());
		assertFalse(matcher06.find());
		assertFalse(matcher07.find());
		assertFalse(matcher08.find());
	}
	@Test
	public void testRegeXmail() {
		Pattern pattern = Pattern.compile(FieldDataType.email.getRegex());
		Matcher matcher01 = pattern.matcher("tom.dhondt@vens-thiers.be");
		Matcher matcher02 = pattern.matcher("");
		Matcher matcher03 = pattern.matcher("1234.00");
		Matcher matcher04 = pattern.matcher("tom.dhondt-vens-thiers.be");
		Matcher matcher05 = pattern.matcher("tom.dhondt@vens-thiersbe");
		Matcher matcher06 = pattern.matcher("1234@vens-thiers.be");
		Matcher matcher07 = pattern.matcher("@vens-thiersbe");
		assertTrue(matcher01.find());
		assertFalse(matcher02.find());
		assertFalse(matcher03.find());
		assertFalse(matcher04.find());
		assertFalse(matcher05.find());
		assertTrue(matcher06.find());
		assertFalse(matcher07.find());
	}
	@Test
	public void testRegeXDecimal() {
		Pattern pattern = Pattern.compile(FieldDataType.decimal.getRegex());
		Matcher matcher01 = pattern.matcher("1234");
		Matcher matcher02 = pattern.matcher("test1234");
		Matcher matcher03 = pattern.matcher("1234.00");
		Matcher matcher04 = pattern.matcher(".1234.00");
		assertFalse(matcher01.find());
		assertFalse(matcher02.find());
		assertTrue(matcher03.find());
		assertFalse(matcher04.find());
	}
	
}
