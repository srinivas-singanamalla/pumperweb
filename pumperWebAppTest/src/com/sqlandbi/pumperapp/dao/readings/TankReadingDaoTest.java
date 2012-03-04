package com.sqlandbi.pumperapp.dao.readings;

import com.sqlandbi.pumperapp.domain.readings.TankReading;

public class TankReadingDaoTest extends ReadingDAOTest<TankReading> {
	
	@Override
	public ReadingDAO<TankReading> getReadingDAO() {
		return new TankReadingDAOImpl();
	}
	
	@Override
	public TestReadings<TankReading> getTestParams() {
		return new TankTestReadings();
	}

}
