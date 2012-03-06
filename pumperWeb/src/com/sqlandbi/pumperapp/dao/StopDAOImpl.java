package com.sqlandbi.pumperapp.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.google.appengine.api.datastore.Key;
import com.sqlandbi.pumperapp.dao.StopDAO;
import com.sqlandbi.pumperapp.domain.StopDetails;
import com.sqlandbi.pumperapp.domain.equipment.Equipment;
import com.sqlandbi.pumperapp.domain.equipment.Tank;
import com.sqlandbi.pumperapp.domain.equipment.Wellhead;

@Component
public class StopDAOImpl implements StopDAO {

	@Override
	public StopDetails addStopDetails(StopDetails stopDetails) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try {
			return pm.makePersistent(stopDetails);
		} finally {
			pm.close();
		}		
	}

	@Override
	public void updateStopDetails(Long id, StopDetails newDetails) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    
		try {
	    	StopDetails e = pm.getObjectById(StopDetails.class, id);
	    	if (e != null) {
	    		newDetails.setStopId(e.getStopId());
	    		pm.makePersistent(newDetails);
	    	}
	    } finally {
	        pm.close();
	    }
		
	}

	@Override
	public StopDetails getStopDetails(Long id) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try {
			StopDetails e = pm.getObjectById(StopDetails.class, id);
			return e;
		}finally {
			pm.close();
		}
	}

	@Override
	public Collection<StopDetails> getStopDetailsList() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		javax.jdo.Query query = pm.newQuery(StopDetails.class);
		Collection<StopDetails> results = (Collection<StopDetails>) query.execute();
		Collection<StopDetails> list = pm.detachCopyAll(results);
		if (CollectionUtils.isEmpty(list)) {
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public void deleteStopDetails(Long id) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			StopDetails e = pm.getObjectById(StopDetails.class, id);
			pm.deletePersistent(e);
		}finally {
			pm.close();
		}
	}

	@Override
	public Collection<Equipment> getEquipments(Long stopId) {
		Collection<Equipment> list = Collections.emptyList();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		StopDetails e = pm.getObjectById(StopDetails.class, stopId);
		Key sampleKey = null;
		for (Key key: e.getEquipments()) {
			sampleKey = key;
			break;
		}
		
		if (e.getEquipments() != null && e.getEquipments().size() > 0) {
			Query query = pm.newQuery(Equipment.class,
	                ":p.contains(equipmentId)");
//			query.declareParameters(Key.class.getName() + " favoriteFoodParam");
			Collection<Equipment> results = (Collection<Equipment>) query.execute(e.getEquipments());
			if (!CollectionUtils.isEmpty(results)) {
				results = pm.detachCopyAll(results);
			}
		}
		/*
		if (e.getEquipments() != null && e.getEquipments().size() > 0) {
			Query query = pm.newQuery(Wellhead.class);
			query.setFilter("equipmentId == favoriteFoodParam");
		    query.declareParameters(Key.class.getName() + " favoriteFoodParam");
		    Collection<Equipment> results = (Collection<Equipment>) query.execute(sampleKey);
		    
			if (!CollectionUtils.isEmpty(results)) {
				list = pm.detachCopyAll(results);
			}
		}*/
		return list;
	}

	@Override
	public Equipment addEquipment(Long stopId, Equipment equipment) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Equipment storedequipment = null;
		try {
			storedequipment = pm.makePersistent(equipment);
			StopDetails e = pm.getObjectById(StopDetails.class, stopId);
			Set<Key> equipmentKeys = e.getEquipments();
			equipmentKeys.add(storedequipment.getEquipmentId());
			return storedequipment;
		} finally {
			pm.close();
		}
	}

	@Override
	public void deleteEquipment(Long equipmentId) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Equipment e = pm.getObjectById(Equipment.class, equipmentId);
			pm.deletePersistent(e);
		}finally {
			pm.close();
		}
	}

}
