package com.sqlandbi.pumperapp.dao.readings;

import com.sqlandbi.pumperapp.domain.readings.WellheadReading;

public class WellheadTestReadings extends TestReadings<WellheadReading>{

	@Override
	public WellheadReading getDayOneReading() {
		WellheadReading reading = new WellheadReading();
		reading.setDate(getDayOne());
		reading.setCasingPressure(34.0);
		reading.setChokeSize(45.0);
		reading.setComments("rwrwrw");
		reading.setDowntime(432.0);
		reading.setDailyProducingStatus(23);
		reading.setTubingPressure(33.0);
		return reading;
	}

	@Override
	public WellheadReading getDayOneMidReading() {
		WellheadReading reading = new WellheadReading();
		reading.setDate(getDayOneMid());
		reading.setCasingPressure(4.0);
		reading.setChokeSize(5.0);
		reading.setComments("dadarwrwrw");
		reading.setDowntime(43.0);
		reading.setTubingPressure(3.0);
		reading.setDailyProducingStatus(223);
		return reading;
	}

	@Override
	public WellheadReading getNextDayReading() {
		WellheadReading reading = new WellheadReading();
		reading.setDate(getNextDay());
		reading.setCasingPressure(42.0);
		reading.setChokeSize(52.0);
		reading.setComments("da2222darwrwrw");
		reading.setDowntime(423.0);
		reading.setDailyProducingStatus(23);
		reading.setTubingPressure(32.0);
		return reading;
	}

	@Override
	public WellheadReading getDayOneReading2() {
		WellheadReading reading = new WellheadReading();
		reading.setDate(getDayOne());
		reading.setCasingPressure(2.0);
		reading.setChokeSize(32.0);
		reading.setComments("da555darwrwrw");
		reading.setDowntime(435.0);
		reading.setTubingPressure(35.0);
		reading.setDailyProducingStatus(283);
		return reading;
	}

}
