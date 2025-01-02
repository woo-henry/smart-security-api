package com.sanesong.security.api.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	private static final DateFormat FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat FORMAT_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String getStartDateTime(final String dateValue) {
		return dateValue + " " + "00:00:00";
	}
	
	public static String getEndDateTime(final String dateValue) {
		return dateValue + " " + "23:59:59";
	}
	
	public static String formatDate(final Date dateValue) {
		return FORMAT_DATE.format(dateValue);
	}
	
	public static String formatDateTime(final Date dateValue) {
		return FORMAT_DATETIME.format(dateValue);
	}
	
	public static String formatDate(final Date dateValue, final String pattern) {
		return new SimpleDateFormat(pattern).format(dateValue);
	}
	
	public static Date parseDate(final String dateValue) {
		try {
			return FORMAT_DATE.parse(dateValue);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date parseDateTime(final String dateValue) {
		try {
			return FORMAT_DATETIME.parse(dateValue);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String addDate(final String dateValue, final int amount) {
		try {
			final Calendar dateCalendar = Calendar.getInstance();
			dateCalendar.setTime(FORMAT_DATE.parse(dateValue));
			dateCalendar.add(Calendar.DAY_OF_YEAR, amount);
			return FORMAT_DATE.format(dateCalendar.getTime());
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String addDateTime(final String dateValue, final int amount) {
		try {
			final Calendar dateCalendar = Calendar.getInstance();
			dateCalendar.setTime(FORMAT_DATETIME.parse(dateValue));
			dateCalendar.add(Calendar.DAY_OF_YEAR, amount);
			return FORMAT_DATETIME.format(dateCalendar.getTime());
		} catch (ParseException e) {
			return null;
		}
	}
}
