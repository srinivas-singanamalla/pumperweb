package com.sqlandbi.pumperapp.dao.readings;

import static com.google.appengine.api.datastore.FetchOptions.Builder.withLimit;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Query;
import com.sqlandbi.pumperapp.BaseObjectTest;
import com.sqlandbi.pumperapp.domain.readings.GasmeterReading;
import com.sqlandbi.pumperapp.domain.readings.Reading;

public abstract class ReadingDAOTest<T> extends BaseObjectTest {

	public abstract TestReadings<T> getTestParams();
	
	public abstract ReadingDAO<T> getReadingDAO();
	
	protected abstract Class<?> getReadingClass();
	
	@Test
	public void testAddReading() {
		T expected = getTestParams().getDayOneReading();
		T actual = getReadingDAO().addReading(expected);
		Assert.assertEquals(expected, actual);
		
		getReadingDAO().addReading(getTestParams().getDayOneMidReading());
		getReadingDAO().addReading(getTestParams().getNextDayReading());
		getReadingDAO().addReading(getTestParams().getDayOneReading2());
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();	
		Assert.assertEquals(4, ds.prepare(new Query(this.getReadingClass().getSimpleName())).countEntities(withLimit(10)));
	}
	
	@Test
	public void testUpdateReading() {
		T expected = getTestParams().getDayOneReading();
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		T actual = getReadingDAO().addReading(expected);	
		Assert.assertEquals(1, ds.prepare(new Query(this.getReadingClass().getSimpleName())).countEntities(withLimit(10)));
		
		T expected2 = getTestParams().getDayOneMidReading();
		Long readingId = ((Reading)actual).getReadingId();
		getReadingDAO().updateReading(readingId, getTestParams().getDayOneMidReading());				
		Assert.assertEquals(1, ds.prepare(new Query(this.getReadingClass().getSimpleName())).countEntities(withLimit(10)));
		
		Collection<T> readingDataCollection = getReadingDAO().getReadings(getDayone(), getNextDay());		
		for (T reading : readingDataCollection) {
			Assert.assertEquals(expected2, reading);
		}
	}
	
	@Test
	public void testGetReadings() {
		Collection<T> expectedCollection = new ArrayList<T>();
		expectedCollection.add(getTestParams().getDayOneReading());
		expectedCollection.add(getTestParams().getDayOneMidReading());
		expectedCollection.add(getTestParams().getNextDayReading());
		expectedCollection.add(getTestParams().getDayOneReading2());
		
		Collection<T> actualCollection = new ArrayList<T>();
		for (T reading : expectedCollection) {
			actualCollection.add(getReadingDAO().addReading((T)reading));
		}
		
		Collection<T> readingDataCollection = getReadingDAO().getReadings(getDayone(), getNextDay());
		Assert.assertEquals(3, readingDataCollection.size());
		
		readingDataCollection = getReadingDAO().getReadings(getDayone(), getDayone());
		Assert.assertEquals(0, readingDataCollection.size());
		
		readingDataCollection = getReadingDAO().getReadings(getDayone(), getNextDay() + 1);
		Assert.assertEquals(4, readingDataCollection.size());
		
		expectedCollection.removeAll(actualCollection);
		Assert.assertEquals(0, expectedCollection.size());
	}
	
	@Test
	public void testDeleteReadings() {
		getReadingDAO().addReading(getTestParams().getDayOneReading());
		getReadingDAO().addReading(getTestParams().getDayOneMidReading());
		getReadingDAO().addReading(getTestParams().getNextDayReading());
		getReadingDAO().addReading(getTestParams().getDayOneReading2());
		
		getReadingDAO().deleteReadings(getDayone(), getDayone());
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();		
		Assert.assertEquals(4, ds.prepare(new Query(this.getReadingClass().getSimpleName())).countEntities(withLimit(10)));
		
		getReadingDAO().deleteReadings(getDayone(), getNextDay());
		Assert.assertEquals(1, ds.prepare(new Query(this.getReadingClass().getSimpleName())).countEntities(withLimit(10)));
	}
	
	
	public Long getDayone() {
		return getTestParams().getDayOne();
	}

	public Long getDayonemid() {
		return getTestParams().getDayOneMid();
	}

	public Long getNextDay() {
		return getTestParams().getNextDay();
	}
	
	@Test
	public void testConfigDates() {
		getTestParams().testConfigDates();
	}

}