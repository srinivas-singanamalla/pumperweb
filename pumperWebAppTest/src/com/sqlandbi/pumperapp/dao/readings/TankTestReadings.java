package com.sqlandbi.pumperapp.dao.readings;

import com.sqlandbi.pumperapp.domain.readings.GasmeterReading;
import com.sqlandbi.pumperapp.domain.readings.TankReading;

public class TankTestReadings extends TestReadings<TankReading> {

	@Override
	public TankReading getDayOneReading() {
		TankReading tankreading = new TankReading();
		tankreading.setDate(getDayOne());
		tankreading.setBbDesc(35.0);
		tankreading.setBottomStart(25.0);
		tankreading.setPurchaserNum(23);
		tankreading.setStock(43);
		tankreading.setTopEnd(44.0);
		tankreading.setTopStart(432.0);
		tankreading.setUseCalc(33.0);		
		return tankreading;
	}

	@Override
	public TankReading getDayOneMidReading() {
		TankReading tankreading = new TankReading();
		tankreading.setDate(getDayOneMid());
		tankreading.setBbDesc(5.0);
		tankreading.setBottomStart(5.0);
		tankreading.setPurchaserNum(13);
		tankreading.setStock(42);
		tankreading.setTopEnd(42.0);
		tankreading.setTopStart(41.0);
		tankreading.setUseCalc(73.0);		
		return tankreading;
	}

	@Override
	public TankReading getNextDayReading() {
		TankReading tankreading = new TankReading();
		tankreading.setDate(getNextDay());
		tankreading.setBbDesc(15.0);
		tankreading.setBottomStart(15.0);
		tankreading.setPurchaserNum(113);
		tankreading.setStock(142);
		tankreading.setTopEnd(142.0);
		tankreading.setTopStart(141.0);
		tankreading.setUseCalc(173.0);		
		return tankreading;
	}

	@Override
	public TankReading getDayOneReading2() {
		TankReading tankreading = new TankReading();
		tankreading.setDate(getDayOne());
		tankreading.setBbDesc(50.0);
		tankreading.setBottomStart(50.0);
		tankreading.setPurchaserNum(130);
		tankreading.setStock(420);
		tankreading.setTopEnd(420.0);
		tankreading.setTopStart(410.0);
		tankreading.setUseCalc(730.0);		
		return tankreading;
	}

}
