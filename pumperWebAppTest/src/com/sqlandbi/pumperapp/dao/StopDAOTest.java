package com.sqlandbi.pumperapp.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import static com.google.appengine.api.datastore.FetchOptions.Builder.withLimit;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.sqlandbi.pumperapp.BaseObjectTest;
import com.sqlandbi.pumperapp.domain.StopDetails;

public class StopDAOTest extends BaseObjectTest {
	
	//TODO use AutoWired
	private StopDAO stopDAO = new StopDAOImpl();
	
	private StopDetails getStopDetails() {
		StopDetails details = new StopDetails();
		details.setDescription("Description of a stop");
		details.setDetails("Details s1");
		details.setId(213232L);
		details.setLatitude("60 23\"43'");
		details.setLontitude("68 29\"63'");
		details.setName("Stop A");
		return details;
	}
	
	private StopDetails getStopDetails2() {
		StopDetails details = new StopDetails();
		details.setDescription("Description of a stop2");
		details.setDetails("Details s2");
		details.setId(2L);
		details.setLatitude("360 223\"143'");
		details.setLontitude("684 229\"623'");
		details.setName("Stop B");
		return details;
	}
	
	private StopDetails getStopDetails3() {
		StopDetails details = new StopDetails();
		details.setDescription("Description of a stop3");
		details.setDetails("Details s3");
		details.setId(212L);
		details.setLatitude("50 23\"453'");
		details.setLontitude("61 24\"863'");
		details.setName("Stop C");
		return details;
	}
		
	@Test
	public void testAddStopDetails() {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Assert.assertEquals(0, ds.prepare(new Query("StopDetails")).countEntities(withLimit(10)));
		StopDetails details = getStopDetails();
		stopDAO.addStopDetails(details);
		Assert.assertEquals(1, ds.prepare(new Query("StopDetails")).countEntities(withLimit(10)));
		
		Query q = new Query("StopDetails");
		q.addFilter("id", Query.FilterOperator.EQUAL, details.getId());
		
		PreparedQuery pq = ds.prepare(q);
		Assert.assertEquals(1, ds.prepare(new Query("StopDetails")).countEntities(withLimit(10)));
		
		for (Entity result: pq.asIterable()) {
			assertStopDetailsEntity(result, details, true);
		}
		//Entity result = pq.asSingleEntity();
		
		
	}
	
	private void assertStopDetailsEntity(Entity result, StopDetails expected, boolean checkId) {
		
		Long id = (Long) result.getProperty("id");
		  String name = (String) result.getProperty("name");
		  String description = (String) result.getProperty("description");
		  String details1 = (String) result.getProperty("details");
		  String longitude = (String) result.getProperty("longitude");
		  String latitude = (String) result.getProperty("latitude");
		  Assert.assertEquals(expected.getName(), name);
		  Assert.assertEquals(expected.getDescription(), description);
		  Assert.assertEquals(expected.getLatitude(), latitude);
		  Assert.assertEquals(expected.getLontitude(), longitude);
		  Assert.assertEquals(expected.getDetails(), details1);
		  if (checkId) {
			  Assert.assertEquals(expected.getId(), id);
		  }
	}
	
	@Test
	public void testUpdateStopDetails() {
		
		
		StopDetails details = getStopDetails();
		stopDAO.addStopDetails(details);
		
		StopDetails details2 = details.clone();
		details2.setId(null);
		details2.setName(details.getName() + "Test");
		details2.setDescription(details.getDescription() + "dsdada");
		details2.setLontitude(details.getLontitude() + "54");		
		stopDAO.updateStopDetails(details.getId(), details2);
		
		Query q = new Query("StopDetails");
		q.addFilter("id", Query.FilterOperator.EQUAL, details.getId());
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		PreparedQuery pq = ds.prepare(q);
		Assert.assertEquals(1, ds.prepare(new Query("StopDetails")).countEntities(withLimit(10)));
		for (Entity result: pq.asIterable()) {
			assertStopDetailsEntity(result, details, true);
			assertStopDetailsEntity(result, details2, false);
			Assert.assertEquals(details.getId(), (Long)result.getProperty("id"));	
		}
		//Entity result = pq.asSingleEntity();
	}

	@Test
	public void testGetStopDetails() {
		StopDetails details = getStopDetails();
		stopDAO.addStopDetails(details);
		
		StopDetails actualDetail = stopDAO.getStopDetails(details.getId());
		Assert.assertEquals(details, actualDetail);
	}
	
	@Test
	public void testgetStopDetailsList() {
		
		stopDAO.addStopDetails(getStopDetails());
		stopDAO.addStopDetails(getStopDetails2());
		stopDAO.addStopDetails(getStopDetails3());		
		
		Collection<StopDetails> actualDetailCollection = stopDAO.getStopDetailsList();
		Assert.assertEquals(3, actualDetailCollection.size());
		
		List<StopDetails> expectedList = new ArrayList<StopDetails>();
		expectedList.add(getStopDetails());
		expectedList.add(getStopDetails2());
		expectedList.add(getStopDetails3());		
		actualDetailCollection.removeAll(expectedList);		
		Assert.assertEquals(0, actualDetailCollection.size());
	}
	
	public void testDeleteStopDetails() {
		StopDetails stopDetail = stopDAO.addStopDetails(getStopDetails());
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Assert.assertEquals(1, ds.prepare(new Query("StopDetails")).countEntities(withLimit(10)));
		
		stopDAO.deleteStopDetails(stopDetail.getId());
		Assert.assertEquals(0, ds.prepare(new Query("StopDetails")).countEntities(withLimit(10)));
		
	}
}
