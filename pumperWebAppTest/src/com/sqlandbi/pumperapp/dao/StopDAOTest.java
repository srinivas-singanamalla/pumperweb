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
import com.sqlandbi.pumperapp.domain.Stop;
import com.sqlandbi.pumperapp.domain.equipment.Equipment;
import com.sqlandbi.pumperapp.domain.equipment.Gasmeter;
import com.sqlandbi.pumperapp.domain.equipment.Tank;
import com.sqlandbi.pumperapp.domain.equipment.Tank.StorageStockType;
import com.sqlandbi.pumperapp.domain.equipment.Wellhead;

public class StopDAOTest extends BaseObjectTest {
	
	//TODO use AutoWired
	private StopDAO stopDAO = new StopDAOImpl();
	
	private Stop getStopDetails() {
		Stop details = new Stop();
		details.setDesc("Description of a stop");
		details.setDetails("Details s1");
		details.setStopId(213232L);
		details.setLatitude("60 23\"43'");
		details.setLongitude("68 29\"63'");
		details.setName("Stop A");
		return details;
	}
	
	private Stop getStopDetails2() {
		Stop details = new Stop();
		details.setDesc("Description of a stop2");
		details.setDetails("Details s2");
		details.setStopId(2L);
		details.setLatitude("360 223\"143'");
		details.setLongitude("684 229\"623'");
		details.setName("Stop B");
		return details;
	}
	
	private Stop getStopDetails3() {
		Stop details = new Stop();
		details.setDesc("Description of a stop3");
		details.setDetails("Details s3");
		details.setStopId(212L);
		details.setLatitude("50 23\"453'");
		details.setLongitude("61 24\"863'");
		details.setName("Stop C");
		return details;
	}
		
	@Test
	public void testAddStopDetails() {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Assert.assertEquals(0, ds.prepare(new Query(Stop.class.getSimpleName())).countEntities(withLimit(10)));
		Stop details = getStopDetails();
		stopDAO.addStopDetails(details);
		Assert.assertEquals(1, ds.prepare(new Query(Stop.class.getSimpleName())).countEntities(withLimit(10)));
		
		Query q = new Query(Stop.class.getSimpleName());
		q.addFilter("id", Query.FilterOperator.EQUAL, details.getStopId());
		
		PreparedQuery pq = ds.prepare(q);
		Assert.assertEquals(1, ds.prepare(new Query(Stop.class.getSimpleName())).countEntities(withLimit(10)));
		
		for (Entity result: pq.asIterable()) {
			assertStopDetailsEntity(result, details, true);
		}
		//Entity result = pq.asSingleEntity();
		
		
	}
	
	private void assertStopDetailsEntity(Entity result, Stop expected, boolean checkId) {
		
		Long id = (Long) result.getProperty("id");
		  String name = (String) result.getProperty("name");
		  String description = (String) result.getProperty("description");
		  String details1 = (String) result.getProperty("details");
		  String longitude = (String) result.getProperty("longitude");
		  String latitude = (String) result.getProperty("latitude");
		  Assert.assertEquals(expected.getName(), name);
		  Assert.assertEquals(expected.getDesc(), description);
		  Assert.assertEquals(expected.getLatitude(), latitude);
		  Assert.assertEquals(expected.getLongitude(), longitude);
		  Assert.assertEquals(expected.getDetails(), details1);
		  if (checkId) {
			  Assert.assertEquals(expected.getStopId(), id);
		  }
	}
	
	@Test
	public void testUpdateStopDetails() {
		
		
		Stop details = getStopDetails();
		stopDAO.addStopDetails(details);
		
		Stop details2 = details.clone();
		details2.setStopId(null);
		details2.setName(details.getName() + "Test");
		details2.setDesc(details.getDesc() + "dsdada");
		details2.setLongitude(details.getLongitude() + "54");		
		stopDAO.updateStopDetails(details.getStopId(), details2);
		
		Query q = new Query(Stop.class.getSimpleName());
		q.addFilter("id", Query.FilterOperator.EQUAL, details.getStopId());
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		PreparedQuery pq = ds.prepare(q);
		Assert.assertEquals(1, ds.prepare(new Query(Stop.class.getSimpleName())).countEntities(withLimit(10)));
		for (Entity result: pq.asIterable()) {
			assertStopDetailsEntity(result, details, true);
			assertStopDetailsEntity(result, details2, false);
			Assert.assertEquals(details.getStopId(), (Long)result.getProperty("id"));	
		}
		//Entity result = pq.asSingleEntity();
	}

	@Test
	public void testGetStopDetails() {
		Stop details = getStopDetails();
		stopDAO.addStopDetails(details);
		
		Stop actualDetail = stopDAO.getStopDetails(details.getStopId());
		Assert.assertEquals(details, actualDetail);
	}
	
	@Test
	public void testgetStopDetailsList() {
		
		stopDAO.addStopDetails(getStopDetails());
		stopDAO.addStopDetails(getStopDetails2());
		stopDAO.addStopDetails(getStopDetails3());		
		
		Collection<Stop> actualDetailCollection = stopDAO.getStopDetailsList();
		Assert.assertEquals(3, actualDetailCollection.size());
		
		List<Stop> expectedList = new ArrayList<Stop>();
		expectedList.add(getStopDetails());
		expectedList.add(getStopDetails2());
		expectedList.add(getStopDetails3());		
		actualDetailCollection.removeAll(expectedList);		
		Assert.assertEquals(0, actualDetailCollection.size());
	}
	
	public void testDeleteStopDetails() {
		Stop stopDetail = stopDAO.addStopDetails(getStopDetails());
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Assert.assertEquals(1, ds.prepare(new Query("StopDetails")).countEntities(withLimit(10)));
		
		stopDAO.deleteStopDetails(stopDetail.getStopId());
		Assert.assertEquals(0, ds.prepare(new Query("StopDetails")).countEntities(withLimit(10)));
		
	}
	
	

	private Equipment getEquipmentTank1StopA() {
		Tank tank = new Tank();
		tank.setDescription("Tank Desc 1");
		tank.setName("Tank Name A");
		tank.setHeight(90.0);
		tank.setRadius(77.0);
		tank.setStorageStock(StorageStockType.OIL.ordinal());
		return tank;
	}
	
	private Equipment getEquipmentTank2StopA() {
		Tank tank = new Tank();
		tank.setDescription("Tank Desc 2");
		tank.setName("Tank Name B");
		tank.setHeight(34.0);
		tank.setRadius(66.0);
		tank.setStorageStock(StorageStockType.OIL.ordinal());
		return tank;
	}
	
	private Equipment getEquipmentGasmeterStopA() {
		Gasmeter tank = new Gasmeter();
		tank.setDescription("Tank Desc 1");
		tank.setName("Tank Name A");
		tank.setMaxPressure(45.0);
		return tank;
	}
	
	private Equipment getEquipmentWellheadStopA() {
		Wellhead tank = new Wellhead();
		tank.setDescription("Tank Desc 1");
		tank.setName("Tank Name A");
		tank.setCasingPressure(45.0);
		tank.setComments("dadadsa");
		tank.setDownTime(56L);
		tank.setProducingMethod(2);
		tank.setTubingPressure(66.0);
		
		return tank;
	}
	
	@Test
	public void testAddEquipment() {
		Stop stop = stopDAO.addStopDetails(getStopDetails());
		getStopDAO().addEquipment(stop.getStopId(), getEquipmentTank1StopA());
		getStopDAO().addEquipment(stop.getStopId(), getEquipmentTank2StopA());
		getStopDAO().addEquipment(stop.getStopId(), getEquipmentGasmeterStopA());
		getStopDAO().addEquipment(stop.getStopId(), getEquipmentWellheadStopA());
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();	
		Assert.assertEquals(2, ds.prepare(new Query(Tank.class.getSimpleName())).countEntities(withLimit(10)));
		Assert.assertEquals(1, ds.prepare(new Query(Gasmeter.class.getSimpleName())).countEntities(withLimit(10)));
		Assert.assertEquals(1, ds.prepare(new Query(Wellhead.class.getSimpleName())).countEntities(withLimit(10)));
	}
	
	@Test
	public void testGetEquipments() {
		Stop stop = stopDAO.addStopDetails(getStopDetails());
		Collection<Equipment> equipments = new ArrayList<Equipment>();
		equipments.add(getEquipmentTank1StopA());
		equipments.add(getEquipmentTank2StopA());
		equipments.add(getEquipmentGasmeterStopA());
		equipments.add(getEquipmentWellheadStopA());
		
		for (Equipment eqmt : equipments) {
			getStopDAO().addEquipment(stop.getStopId(), eqmt);
		}
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();	
		Assert.assertEquals(2, ds.prepare(new Query(Tank.class.getSimpleName())).countEntities(withLimit(10)));
		Assert.assertEquals(1, ds.prepare(new Query(Gasmeter.class.getSimpleName())).countEntities(withLimit(10)));
		Assert.assertEquals(1, ds.prepare(new Query(Wellhead.class.getSimpleName())).countEntities(withLimit(10)));
		
		Stop stopDetails = getStopDAO().getStopDetails(stop.getStopId());
		
		Collection<Equipment> actualEquipments = getStopDAO().getEquipments(stopDetails.getStopId());
		Assert.assertEquals(actualEquipments.size(), 4);
		
		equipments.removeAll(actualEquipments);
		Assert.assertEquals(0, equipments.size());
	}
	@Test
	public void testDeleteEquipments() {
		Stop stop = stopDAO.addStopDetails(getStopDetails());
		Collection<Equipment> equipments = new ArrayList<Equipment>();
		equipments.add(getEquipmentTank1StopA());
		equipments.add(getEquipmentTank2StopA());
		equipments.add(getEquipmentGasmeterStopA());
		equipments.add(getEquipmentWellheadStopA());
		
		for (Equipment eqmt : equipments) {
			getStopDAO().addEquipment(stop.getStopId(), eqmt);
		}
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();	
		Assert.assertEquals(2, ds.prepare(new Query(Tank.class.getSimpleName())).countEntities(withLimit(10)));
		Assert.assertEquals(1, ds.prepare(new Query(Gasmeter.class.getSimpleName())).countEntities(withLimit(10)));
		Assert.assertEquals(1, ds.prepare(new Query(Wellhead.class.getSimpleName())).countEntities(withLimit(10)));
		
		stopDAO.deleteEquipments(stop.getStopId());
		Assert.assertEquals(0, ds.prepare(new Query(Tank.class.getSimpleName())).countEntities(withLimit(10)));
		Assert.assertEquals(0, ds.prepare(new Query(Gasmeter.class.getSimpleName())).countEntities(withLimit(10)));
		Assert.assertEquals(0, ds.prepare(new Query(Wellhead.class.getSimpleName())).countEntities(withLimit(10)));
		
	}
	
	StopDAO getStopDAO() {
		return stopDAO;
	}
}
