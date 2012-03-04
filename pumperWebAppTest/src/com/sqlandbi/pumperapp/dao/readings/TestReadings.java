package com.sqlandbi.pumperapp.dao.readings;

import java.util.Calendar;

import org.junit.Test;

import junit.framework.Assert;


public abstract class TestReadings<T> {

	public abstract T getDayOneReading();

	public abstract T getDayOneMidReading();

	public abstract T getNextDayReading();

	public abstract T getDayOneReading2();

	
	public Long getDayOne() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2006, 10, 25);
		System.out.println("dayone " + cal.getTimeInMillis());
		return cal.getTimeInMillis();
	}

	public Long getDayOneMid() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2006, 10, 25);
		cal.set(Calendar.HOUR_OF_DAY, 9);
		System.out.println("getDayonemid " + cal.getTimeInMillis());
		return cal.getTimeInMillis();
	}

	public Long getNextDay() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2006, 10, 26);
		System.out.println("getNextDay " + cal.getTimeInMillis());
		return cal.getTimeInMillis();
	}
		
	@Test
	public void testConfigDates() {
		Assert.assertEquals(getDayOne(), getDayOne()); 
		long diffInMillisecs = getNextDay() - (getDayOne() + 24*60*60*1000L);
		Assert.assertEquals(diffInMillisecs, 0L);
	}

}