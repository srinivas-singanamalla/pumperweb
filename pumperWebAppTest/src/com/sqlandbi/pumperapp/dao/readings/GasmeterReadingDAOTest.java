package com.sqlandbi.pumperapp.dao.readings;

import com.sqlandbi.pumperapp.domain.readings.GasmeterReading;

public class GasmeterReadingDAOTest extends ReadingDAOTest<GasmeterReading>{

	@Override
	public ReadingDAO<GasmeterReading> getReadingDAO() {
		// TODO Auto-generated method stub
		return new GasmeterReadingDAOImpl();
	}
	
	@Override
	public TestReadings<GasmeterReading> getTestParams() {
		return new GasmeterTestReadings();
	}

}
