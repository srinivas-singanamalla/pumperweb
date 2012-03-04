package com.sqlandbi.pumperapp.dao.readings;

import static com.google.appengine.api.datastore.FetchOptions.Builder.withLimit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Query;
import com.sqlandbi.pumperapp.BaseObjectTest;
import com.sqlandbi.pumperapp.domain.readings.GasmeterReading;
import com.sqlandbi.pumperapp.domain.readings.Reading;

public class GasmeterReadingDAOTest extends BaseObjectTest {

	//use autowire
	private GasmeterReadingDAO readingDAO = new GasmeterReadingDAOImpl();
	
	
	private Long getDayone() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2006, 10, 25);
		System.out.println("dayone " + cal.getTimeInMillis());
		return cal.getTimeInMillis();
	}
	
	private Long getDayonemid() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2006, 10, 25);
		cal.set(Calendar.HOUR_OF_DAY, 9);
		System.out.println("getDayonemid " + cal.getTimeInMillis());
		return cal.getTimeInMillis();
	}
	
	private Long getNextDay() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2006, 10, 26);
		System.out.println("getNextDay " + cal.getTimeInMillis());
		return cal.getTimeInMillis();
	}
	
	private GasmeterReading  getGasmeterReading() {
		GasmeterReading reading1 = new GasmeterReading();
		reading1.setDate(getDayone());
		reading1.setDifferential(34.6);
		reading1.setLinePressure(56.7);
		reading1.setTemperature(67.9);
		return reading1;
	}
	
	private GasmeterReading  getGasmeterReading2() {
		GasmeterReading reading1 = new GasmeterReading();
		reading1.setDate(getDayonemid());
		reading1.setDifferential(35.6);
		reading1.setLinePressure(235.7);
		reading1.setTemperature(69.9);
		return reading1;
	}
	
	private GasmeterReading  getGasmeterReading3() {
		GasmeterReading reading1 = new GasmeterReading();
		reading1.setDate(getNextDay());
		reading1.setDifferential(141.6);
		reading1.setLinePressure(62.7);
		reading1.setTemperature(17.9);
		return reading1;
	}
	
	private GasmeterReading  getGasmeterReading4() {
		GasmeterReading reading1 = new GasmeterReading();
		reading1.setDate(getDayone());
		reading1.setDifferential(141.6);
		reading1.setLinePressure(62.7);
		reading1.setTemperature(17.9);
		return reading1;
	}
	
	@Test
	public void testConfigDates() {
		Assert.assertEquals(getDayone(), getDayone()); 
		long diffInMillisecs = getNextDay() - (getDayone() + 24*60*60*1000L);
		Assert.assertEquals(diffInMillisecs, 0L);
	}
	
	@Test
	public void testAddReading() {
		GasmeterReading expected = getGasmeterReading();
		GasmeterReading actual = readingDAO.addReading(expected);
		Assert.assertEquals(expected, actual);
		
		readingDAO.addReading(getGasmeterReading2());
		readingDAO.addReading(getGasmeterReading3());
		readingDAO.addReading(getGasmeterReading4());
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();		
		Assert.assertEquals(4, ds.prepare(new Query("GasmeterReading")).countEntities(withLimit(10)));
	}
	
	@Test
	public void testUpdateReading() {
		GasmeterReading expected = getGasmeterReading();
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		GasmeterReading actual = readingDAO.addReading(expected);	
		Assert.assertEquals(1, ds.prepare(new Query("GasmeterReading")).countEntities(withLimit(10)));
		
		Reading expected2 = getGasmeterReading2();
		readingDAO.updateReading(actual.getReadingId(), getGasmeterReading2());				
		Assert.assertEquals(1, ds.prepare(new Query("GasmeterReading")).countEntities(withLimit(10)));
		
		Collection<GasmeterReading> readingDataCollection = readingDAO.getReadings(getDayone(), getNextDay());		
		for (Reading reading : readingDataCollection) {
			Assert.assertEquals(expected2, reading);
		}
	}
	
	@Test
	public void testGetReadings() {
		Collection<Reading> expectedCollection = new ArrayList<Reading>();
		expectedCollection.add(getGasmeterReading());
		expectedCollection.add(getGasmeterReading2());
		expectedCollection.add(getGasmeterReading3());
		expectedCollection.add(getGasmeterReading4());
		
		Collection<Reading> actualCollection = new ArrayList<Reading>();
		for (Reading reading : expectedCollection) {
			actualCollection.add(readingDAO.addReading((GasmeterReading)reading));
		}
		
		Collection<GasmeterReading> readingDataCollection = readingDAO.getReadings(getDayone(), getNextDay());
		Assert.assertEquals(3, readingDataCollection.size());
		
		readingDataCollection = readingDAO.getReadings(getDayone(), getDayone());
		Assert.assertEquals(0, readingDataCollection.size());
		
		readingDataCollection = readingDAO.getReadings(getDayone(), getNextDay() + 1);
		Assert.assertEquals(4, readingDataCollection.size());
		
		expectedCollection.removeAll(actualCollection);
		Assert.assertEquals(0, expectedCollection.size());
	}
	
	@Test
	public void testDeleteReadings() {
		readingDAO.addReading(getGasmeterReading());
		readingDAO.addReading(getGasmeterReading2());
		readingDAO.addReading(getGasmeterReading3());
		readingDAO.addReading(getGasmeterReading4());
		
		readingDAO.deleteReadings(getDayone(), getDayone());
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();		
		Assert.assertEquals(4, ds.prepare(new Query("GasmeterReading")).countEntities(withLimit(10)));
		
		readingDAO.deleteReadings(getDayone(), getNextDay());
		Assert.assertEquals(1, ds.prepare(new Query("GasmeterReading")).countEntities(withLimit(10)));
	}
}