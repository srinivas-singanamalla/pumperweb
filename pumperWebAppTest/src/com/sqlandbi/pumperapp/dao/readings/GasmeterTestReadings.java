package com.sqlandbi.pumperapp.dao.readings;


import com.sqlandbi.pumperapp.domain.readings.GasmeterReading;

public class GasmeterTestReadings extends TestReadings<GasmeterReading> {

	public GasmeterTestReadings() {
		super();
	}

	@Override
	public GasmeterReading getDayOneReading() {
		GasmeterReading reading1 = new GasmeterReading();
		reading1.setDate(getDayOne());
		reading1.setDifferential(34.6);
		reading1.setLinePressure(56.7);
		reading1.setTemperature(67.9);
		return reading1;
	}

	@Override
	public GasmeterReading getDayOneMidReading() {
		GasmeterReading reading1 = new GasmeterReading();
		reading1.setDate(getDayOneMid());
		reading1.setDifferential(35.6);
		reading1.setLinePressure(235.7);
		reading1.setTemperature(69.9);
		return reading1;
	}

	@Override
	public GasmeterReading getNextDayReading() {
		GasmeterReading reading1 = new GasmeterReading();
		reading1.setDate(getNextDay());
		reading1.setDifferential(141.6);
		reading1.setLinePressure(62.7);
		reading1.setTemperature(17.9);
		return reading1;
	}

	@Override
	public GasmeterReading getDayOneReading2() {
		GasmeterReading reading1 = new GasmeterReading();
		reading1.setDate(getDayOne());
		reading1.setDifferential(141.6);
		reading1.setLinePressure(62.7);
		reading1.setTemperature(17.9);
		return reading1;
	}

	

}