package com.sqlandbi.pumperapp.dao.readings;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.sqlandbi.pumperapp.BaseObjectTest;

public class BaseReadingTest extends BaseObjectTest{
	/*
	public Long getDayone() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2006, 10, 25);
		System.out.println("dayone " + cal.getTimeInMillis());
		return cal.getTimeInMillis();
	}

	public Long getDayonemid() {
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
		Assert.assertEquals(getDayone(), getDayone()); 
		long diffInMillisecs = getNextDay() - (getDayone() + 24*60*60*1000L);
		Assert.assertEquals(diffInMillisecs, 0L);
	}
*/

}
