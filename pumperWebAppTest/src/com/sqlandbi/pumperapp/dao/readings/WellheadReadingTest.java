package com.sqlandbi.pumperapp.dao.readings;

import org.junit.Test;

import com.sqlandbi.pumperapp.BaseObjectTest;
import com.sqlandbi.pumperapp.domain.readings.GasmeterReading;
import com.sqlandbi.pumperapp.domain.readings.WellheadReading;


public class WellheadReadingTest extends ReadingDAOTest<WellheadReading>{

	@Override
	public TestReadings<WellheadReading> getTestParams() {
		return new WellheadTestReadings();
	}

	@Override
	public ReadingDAO<WellheadReading> getReadingDAO() {
		return new WellheadReadingDAOImpl();
	}

	@Override
	protected Class<?> getReadingClass() {
		return WellheadReading.class;
	}
	
	

}
