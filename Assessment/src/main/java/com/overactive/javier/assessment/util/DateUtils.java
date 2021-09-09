package com.overactive.javier.assessment.util;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	/**
	 * Subtract the value of monts from the given date
	 * 
	 * @param date  from which the months will be subtracted
	 * @param monts that will be subtracted
	 * @return the new date
	 */
	public static Date substractMonths(Date date, int monts) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -monts);
		return c.getTime();
	}

	/**
	 * Get the name of the month from your order number
	 * 
	 * @param monthOrder a number between 0 and 11 that represents the month of the
	 *                   year
	 * @return the name of the month
	 */
	public static String getMonthForInt(int monthOrder) {
		String month = "None";
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		if (monthOrder >= 0 && monthOrder <= 11) {
			month = months[monthOrder];
		}
		return month;
	}

	/**
	 * Gets the name of the month of a given date
	 * 
	 * @param date
	 * @return the name of the month
	 */
	public static String getMonth(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		return getMonthForInt(month - 1);
	}

}
